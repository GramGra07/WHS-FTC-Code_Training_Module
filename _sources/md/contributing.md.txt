# Contributing

This project serves as a starting point for many rookies to FTC to get started in the program.

## Prerequisites

* **[Git](https://git-scm.com/downloads):** To clone the repository.
* **[Python 3.x](https://www.python.org/downloads/):** Required to run Sphinx (the documentation generator). *Make sure to check the box that says "Add Python to PATH" during installation.*
* **[Node.js and npm](https://nodejs.org/):** Required to run local development scripts.

## Installation and Setup

1. Clone the Repository

```bash
git clone [https://github.com/YOUR-ORG/WHS-FTC-Code_Training_Module.git](https://github.com/YOUR-ORG/WHS-FTC-Code_Training_Module.git)
cd WHS-FTC-Code_Training_Module
```

2. Navigate to docs folder

```bash
cd docs
```

3. Install python Dependencies

```bash
pip install sphinx sphinx-autobuild
```

4. Install NPM Dependencies

```bash
npm install
```

## Structure

Each folder contains an `index.rst` file which contains the structure for that folder. The root `index.rst` contains the paths to every other `index.rst` to include.

Pages are all build in `md` (Markdown), and are converted to `html` with sphinx. If you are adding a folder, you will need to add a folder, `index.rst` and direct the `/root/index.rst` to your new folder. Please see existing folders for examples.

## Running the Local Dev Server

To see your changes in real time,

```bash
npm run start
```

Which will run all of the commands necessary, deploy a live server, and open that server in your computer's browser. This will automatically rebuild on changes so it will be processing very frequently.

## Ensuring Links are Valid

When adding links, run the command 
```bash
npm run linkcheck
```

Which will then check all links in the document