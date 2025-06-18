# 1337 Header Generator

<p align="center">
  <a href="https://www.oracle.com/java">
    <img src="https://img.shields.io/badge/Java-11%2B-%23ED8B00?style=for-the-badge&logo=java" alt="Java 11+">
  </a>
  <a href="https://en.wikipedia.org/wiki/C_(programming_language)">
    <img src="https://img.shields.io/badge/Programming-%2300599C?style=for-the-badge&logo=c&logoColor=white" alt="C Language">
  </a>
  <a href="#">
    <img src="https://img.shields.io/badge/status-Beta-yellow?style=for-the-badge" alt="Beta Badge" />
  </a>
  <a href="https://www.gnu.org/licenses/gpl-3.0">
    <img src="https://img.shields.io/badge/License-GPLv3-%234C1?style=for-the-badge&logo=gnu&logoColor=white" alt="License GPL v3">
  </a>
</p>

<p align="center">
  <img src="https://res.cloudinary.com/dpwnvpf63/image/upload/v1749674109/UM6P_1337_hqcnme.jpg" alt="1337 Logo" width="160" style="border-radius: 15%;" />
    &nbsp;&nbsp;&nbsp;
<img src="src/main/resources/1337CodingSchool.png" alt="1337 Logo" width="160" style="border-radius: 15%;" />
  
</p>


#### A minimal, **zero-dependency** Java utility that prepends the iconic [1337 School](https://1337.ma/) style ASCII header to your source files.



![note](src/main/resources/note.png)




---

## ✨ Features

- **Single File Injection**: Add a header to one specified file.
- **Bulk Injection**: Process a list of files in one call.
- **Project-wide Injection**: Recursively inject headers into files matching given extensions (e.g., `.c`, `.java`, `.kt`).
- **Automatic Metadata**: Dynamically replaces placeholders with **filename**, **author**, **email**, **creation**, and **update timestamps**.
- **Alignment Guarantee**: Maintains the original ASCII-art layout regardless of filename length.
- **Zero Dependencies**: Ships as a single fat JAR—no external libraries.

---

## 📸 Header Preview

![alt text](src/main/resources/preview.png)

---

## 🚀 Quick Start

### 1. Clone & Build

```bash
git clone https://github.com/SoufianoDev/1337HeaderGenerator.git
cd 1337HeaderGenerator
mvn clean package
```

## Programmatic Usage :

```java
import com.soufianodev.LeetHeaderGenerator;

public class Main {
    public static void main(String[] args) throws Exception {

        LeetHeaderGenerator leetHeader = new LeetHeaderGenerator();

        leetHeader.setStudentData("SoufianoDev", "soufianodev@student.1337.ma");

        // Single file
        leetHeader.addHeaderToSingleFile("src/com/soufianodev/MyFile.c");

        // Selected files
        leetHeader.addHeaderToSelectedFiles(
            List.of("ft_putchar.c", "strlibrary.h", "Pool.kt","FtPrintComb.java")
        );

        // All project files with extensions
        generator.addHeaderToAllProjectFiles(".java", ".c", ".kt");
    }
}
```

---

## 🗂️ Project Structure

```
1337HeaderGenerator/
├── LICENSE
├── README.md
├── pom.xml                # Maven build file
├── src/
│   ├── main/java/com/soufianodev/
│   │   ├── LeetHeaderGenerator.java
│   │   └── Main.java
│   └── test/java/         # Unit tests (TBD)
└── docs/                  # Assets (header-preview.png, etc.)
```

---

## 🤝 Contributing

1. **Fork** the repository
2. Create a **feature branch** (`git checkout -b feature/foo`)
3. **Commit** your changes (`git commit -m "feat: add foo"`)
4. **Push** and open a **Pull Request** 🚀

Please adhere to the existing code style and include tests for new features.

---

## 📜 License

This project is licensed under the **GNU General Public License v3.0**. See the full [LICENSE](LICENSE) file for more information.

---

## 🧑‍💻 Author

**Soufiano Dev** – [@SoufianoDev](https://github.com/SoufianoDev)
