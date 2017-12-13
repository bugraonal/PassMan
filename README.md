# CS320 Fall 2017 Project
# PassMan - Password Manager

## Getting Started

### Prerequisites

You have to have the following tools in order to successfully compile the code.
```
Java 6 or later
```

## Project Structure

### General folder structure
In general, we agreed on an MVC structure. 

There are three different folders called 
* GUI
* GUIListener
* PassMan

#### GUI

In GUI we keep the user interface of the software. All view related methods and functionalities will be here.

#### GUIListener

This is where we create the listeners that the user interface will use to communicate with the user. Any graphical changes requiring input will reside here.

#### PassMan

Here we keep all non-view related source. Database IO, Passman execution, AES/SHA256 encryption and so will have their sources here.

## Documents

### Report

[Report](./Report.md)

## Contributing

Please don't make direct changes to the master branch. Use a 
seperate branch with 
```
git checkout -b <things-that-you're-going-to-change>
```
and after testing it thoroughly, merge it to master and inform your
partner about master changes. 

## Authors
* **Emir Ünlütürk**
* **Buğra Önal**
* **Onur Yıkılmazoğlu**
* **Doruk Çelebi**
* **Onat Güngör**

<sup>Contents of the project are subject to change, do keep in mind that project is under active development</sup>
