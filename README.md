# 1337 Header Generator

<p align="center">
<a href="https://www.oracle.com/java"><img src="https://img.shields.io/badge/Java-11%2B-%23ED8B00?style=for-the-badge&logo=java" alt="Java 11+"></a>
<a href="https://en.wikipedia.org/wiki/C_(programming_language)"><img src="https://img.shields.io/badge/Programming-%2300599C?style=for-the-badge&logo=c&logoColor=white" alt="C Language"></a>
<a href="https://www.gnu.org/licenses/gpl-3.0"><img src="https://img.shields.io/badge/License-GPLv3-%234C1?style=for-the-badge&logo=gnu&logoColor=white" alt="License GPL v3"></a>
</p>

A minimal, **zero-dependency** Java utility that prepends the iconic [1337 School](https://1337.ma/) style ASCII header to your source files.

<div style="
  max-width: 420px;
  margin: 20px auto;
  padding: 20px 24px;
  border-radius: 12px;
  background: linear-gradient(145deg, #000000, #0d1117);
  color: #39ff14;
  border: 2px solid #00ff88;
  font-family: 'Fira Code', monospace;
  font-size: 15px;
  white-space: pre-wrap;
  overflow-x: auto;
  box-shadow: 0 0 25px #00ff88;
  text-shadow: 0 0 5px #00ff88;
  text-align: center;
">
  Note: This project is in Beta. Unexpected errors may occur. Your feedback and issue reports are essential to help improve and develop the project further. Thank you for your support.
</div>




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

<div style="
  background: linear-gradient(145deg, #000000, #0d1117);
  color: #39ff14;
  border: 2px solid #00ff88;
  border-radius: 16px;
  padding: 20px;
  font-family: 'Fira Code', 'Courier New', Courier, monospace;
  font-size: 15px;
  white-space: pre;
  overflow-x: auto;
  box-shadow: 0 0 25px #00ff88;
  text-shadow: 0 0 5px #00ff88;
  text-align: center;
">
<span style="color:#00ff88">/* ************************************************************************************ */</span>
<span style="color:#00cc66">/*                                                                                      */</span>
<span style="color:#00cc66">/*                                                                                      */</span>
<span style="color:#39ff14">/*   ft_putchar.c                                    +#::     +####:   +####:   ######  */</span>
<span style="color:#39ff14">/*                                                   ##::     #::::#   #::::#       #:  */</span>
<span style="color:#ff44ff">/*   By: Soufiano &lt;soufiano@student.1337.ma&gt;          #::         #:       #:      #:   */</span>
<span style="color:#39ff14">/*                                                    #::     +###:    +###:     #:     */</span>
<span style="color:#00ffcc">/*   Created: 2025/06/17 02:34:00 by Soufiano         #::         #:       #:   #:      */</span>
<span style="color:#00ffcc">/*   Updated: 2025/06/17 03:00:00 by Soufiano         #::     #::::#   #:::::  #:       */</span>
<span style="color:#39ff14">/*                                                  #######   +####:  +####:  #.ma      */</span>
<span style="color:#00cc66">/*                                                                                      */</span>
<span style="color:#00ff88">/* ************************************************************************************ */</span>
</div>


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
