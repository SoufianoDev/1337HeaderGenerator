
/**
 * =============================================================================  *
 *  File        : LeetHeaderGenerator.java                                        *
 *  Project     : 1337.ma ASCII Header Injector                                      *
 *  Author      : Soufiano Dev <contact.devsoufiano@gmail.com>                    *
 *  Created on  : 2025-06-17                                                      *
 *  Description : Generates and injects a stylized 1337-style ASCII art header    *
 *                into C/Java files with dynamic metadata (file name, author,     *
 *                timestamps) while preserving formatting and layout.             *
 *                                                                                *
 *  License     : GNU General Public License v3.0                                 *
 *                This program is free software: you can redistribute it and/or   *
 *                modify it under the terms of the GNU GPL as published by the    *
 *                Free Software Foundation, either version 3 .                    *
 *                                                                                *
 *                This program is distributed in the hope that it will be useful, *
 *                but WITHOUT ANY WARRANTY; without even the implied warranty of  *
 *                MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the    *
 *                GNU General Public License for more details.                    *
 * =============================================================================  *
 */


package com.soufianodev;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * LeetHeaderGenerator automatically adds a custom ASCII-art header
 * to source code files (e.g., .c, .java, .kt) with author and timestamp metadata.
 *
 * The header maintains strict alignment and structure following a 1337-style format.
 *
 * Supported features:
 * - Inserting headers into a single file
 * - Bulk header insertion into selected files
 * - Recursively processing project files with specific extensions
 */
public class LeetHeaderGenerator {
    private static final int MAX_LINE_LEN = 100;
    private static final int MAX_LINES = 12;

    /** The reference ASCII header template. */
    private static final String[] referenceTemplateLines = {
            "/* ************************************************************************************ */",
            "/*                                                                                      */",
            "/*                                                                                      */",
            "/*   ft_ascii_1337.c                                 +#::     +####:   +####:   ######  */",
            "/*                                                   ##::     #::::#   #::::#       #:  */",
            "/*   By: Soufiano <soufiano@student.1337.ma>          #::         #:       #:      #:   */",
            "/*                                                    #::     +###:    +###:     #:     */",
            "/*   Created: 2025/06/17 02:34:00 by Soufiano         #::         #:       #:   #:      */",
            "/*   Updated: 2025/06/17 03:00:00 by Soufiano         #::     #::::#   #:::::  #:       */",
            "/*                                                  #######   +####:  +####:  #.ma      */",
            "/*                                                                                      */",
            "/* ************************************************************************************ */"
    };

    private String fileName;
    private String authorName;
    private String authorEmail;
    private String[] output = new String[MAX_LINES];

    /**
     * Sets the current file name to be used for header generation.
     * @param fileName full or relative path of the file.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Sets the student's name and email used in the "By:" line.
     * @param name the author name
     * @param email the author email
     */
    public void setStudentData(String name, String email) {
        this.authorName = name;
        this.authorEmail = email;
    }

    /**
     * Generates the header lines based on the template, replacing
     * the filename, author, and timestamps dynamically.
     */
    private void generateHeader() {
        String[] lines = Arrays.copyOf(referenceTemplateLines, MAX_LINES);
        String baseName = Paths.get(fileName).getFileName().toString();
        String timestamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

        for (int i = 0; i < MAX_LINES; i++) {
            lines[i] = replaceFileName(lines[i], "ft_ascii_1337.c", baseName);
            lines[i] = replaceByLine(lines[i]);
        }
        lines[7] = replaceTimestampLine(lines[7], "Created", timestamp);
        lines[8] = replaceTimestampLine(lines[8], "Updated", timestamp);
        output = lines;
    }

    /**
     * Replaces the filename in the template line, preserving formatting.
     */
    private String replaceFileName(String line, String oldName, String newName) {
        int index = line.indexOf(oldName);
        if (index == -1) return line;
        StringBuilder sb = new StringBuilder();
        sb.append(line, 0, index).append(newName);
        int diff = oldName.length() - newName.length();
        if (diff > 0) sb.append(" ".repeat(diff));
        else if (diff < 0) index += -diff;
        sb.append(line.substring(Math.min(index + oldName.length(), line.length())));
        return sb.toString();
    }

    /**
     * Replaces the "By: ..." line with the author's name and email, aligned before ASCII art.
     */
    private String replaceByLine(String line) {
        int index = line.indexOf("By: ");
        if (index == -1 || authorName == null || authorEmail == null) return line;
        int artIndex = line.indexOf("+#");
        if (artIndex == -1) artIndex = line.indexOf("##");
        if (artIndex == -1) return line;
        String info = authorName + " <" + authorEmail + ">";
        StringBuilder sb = new StringBuilder(line.substring(0, index + 4)).append(info);
        while (sb.length() < artIndex) sb.append(" ");
        sb.append(line.substring(artIndex));
        return sb.toString();
    }

    /**
     * Replaces the created/updated timestamp line while preserving ASCII art alignment.
     */
    private String replaceTimestampLine(String line, String tag, String timestamp) {
        int artIndex = line.indexOf("+#");
        if (artIndex == -1) artIndex = line.indexOf("##");
        if (artIndex == -1) return line;
        String text = String.format("/*   %s: %-20s by %-11s", tag, timestamp, authorName);
        StringBuilder sb = new StringBuilder(text);
        while (sb.length() < artIndex) sb.append(" ");
        sb.append(line.substring(artIndex));
        return sb.toString();
    }

    /**
     * Inserts the generated header at the top of the given file.
     * @param path path to the file to modify
     * @throws IOException if reading or writing the file fails
     */
    public void writeHeaderToFile(String path) throws IOException {
        setFileName(path);
        generateHeader();
        Path file = Paths.get(path);
        List<String> originalLines = Files.readAllLines(file);
        List<String> newLines = new ArrayList<>(Arrays.asList(output));
        newLines.add("");
        newLines.addAll(originalLines);
        Files.write(file, newLines);
    }

    /**
     * Adds a header to a single file.
     * @param path path to the file
     * @throws IOException if file I/O fails
     */
    public void addHeaderToSingleFile(String path) throws IOException {
        writeHeaderToFile(path);
    }

    /**
     * Adds headers to a list of selected files.
     * @param filePaths list of file paths
     * @throws IOException if file I/O fails
     */
    public void addHeaderToSelectedFiles(List<String> filePaths) throws IOException {
        for (String path : filePaths) writeHeaderToFile(path);
    }

    /**
     * Recursively adds headers to all files in the project
     * matching the given extensions (e.g. ".c", ".java", ".kt").
     *
     * @param extensions file extensions to match
     * @throws IOException if file traversal or writing fails
     */
    public void addHeaderToAllProjectFiles(String... extensions) throws IOException {
        Files.walk(Paths.get("."))
                .filter(Files::isRegularFile)
                .filter(path -> {
                    String name = path.getFileName().toString();
                    for (String ext : extensions) {
                        if (name.endsWith(ext)) return true;
                    }
                    return false;
                })
                .forEach(path -> {
                    try {
                        writeHeaderToFile(path.toString());
                    } catch (IOException e) {
                        System.err.println("Failed: " + path);
                    }
                });
    }
}
