# File Organizer

File Organizer is a simple Java application that allows you to organize files from a source folder into destination folders based on their file extensions. It provides a user-friendly graphical interface for selecting source and destination folders and organizing the files.

![image](https://github.com/mrharshdalal/FileOrganizer_Java/assets/64740456/481c03ea-e3bf-4e47-8838-11e97db0998b)

![image](https://github.com/mrharshdalal/FileOrganizer_Java/assets/64740456/15eed708-3c8b-4c7e-b9f0-0e944e2efe09)

![image](https://github.com/mrharshdalal/FileOrganizer_Java/assets/64740456/5142b105-5bcb-4aa8-8ce1-1a65e38d7b1a)

![image](https://github.com/mrharshdalal/FileOrganizer_Java/assets/64740456/64609b13-da7a-41b7-b6b3-2074525c9477)


## Features

- Select a source folder containing unorganized files.
- Choose a destination folder where the organized files will be moved.
- Organize files by moving them to subfolders based on their file extensions.
- User-friendly GUI for easy navigation and execution.

## Algorithm and Flow

### User Interface Initialization

- The application window is created with labels, text fields, and buttons for selecting the source folder, destination folder, and organizing files.
- The "Browse" buttons allow users to select folders using a file chooser dialog.
- When the "Organize" button is clicked, the action is triggered, and the file organization process begins.

### Source and Destination Folder Selection

- The user clicks the "Browse" button next to the "Source Folder" field to select the folder containing unorganized files.
- Similarly, the user selects the destination folder where the organized files will be moved by clicking the "Browse" button next to the "Destination Folder" field.

### File Organization Process

- When the user clicks the "Organize" button, the action event is handled by the `actionPerformed()` method.
- The selected source and destination folders are obtained from the text fields.
- The application checks if the source and destination folders exist. If not, it displays an error message and exits the process.
- If both folders exist, the application proceeds with the organization process.

### Iterating Through Files

- The application retrieves a list of files from the source folder.
- It iterates through each file in the list.

### File Extension Extraction

- For each file, the application extracts its file extension. This is done by parsing the file name to find the characters after the last dot (`.`).

### Creating Subfolders

- The application checks if a subfolder with the same name as the file extension exists in the destination folder.
- If the subfolder does not exist, it creates one.

### Moving Files

- The application moves the file from the source folder to the corresponding subfolder in the destination folder based on its file extension.
- It uses file input and output streams to perform the file move operation.

### Error Handling

- If any errors occur during the file organization process (e.g., invalid folders, file I/O errors), the application displays an error message.

### Success Message

- After successfully organizing all files, the application displays a success message indicating that the files have been organized.

### Completion

- The file organization process is complete, and the user can continue organizing more files or close the application.

The algorithm ensures that files from the source folder are categorized into subfolders based on their file extensions in the destination folder. It provides error handling to notify the user of any issues that may arise during the organization process.

## Getting Started

### Prerequisites

Make sure you have the following installed on your system:

- Java Development Kit (JDK) 8 or higher
- Git (optional)

### Installation

1. Clone the repository (if you haven't already):

   ```bash
   git clone https://github.com/mrharshdalal/file-organizer-java.git
