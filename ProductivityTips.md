- [1. Productivity](#1-productivity)
  - [1.1. Automation in command line:](#11-automation-in-command-line)
  - [1.2. Add alias in Git](#12-add-alias-in-git)
  - [1.3. Productivity videos](#13-productivity-videos)
- [2. Useful extensions](#2-useful-extensions)
- [3. Useful Plugin Visual Studio](#3-useful-plugin-visual-studio)


# 1. Productivity 
- Knowing IDE shortcuts (IntellJ)
 -  Install plugin Key Promoter X
 -  checkout Productivity Guide (Double shift -> type  productivity)
- F2 to trace error in the file
- CTRL+Space
- IDE Live templates, context-aware suggestions & code generation
- cmd+shift+p in vscode is very helpful to remember shortcuts and recently used commands
-  https://www.tabnine.com/ is a great autocompletion tool for vscode

## 1.1. Automation in command line: 
- Composing commands, piping, subshells
All the steps like package, shipping(docker) and installing to container register can be automated by create a Shell scripting.
- Installing Zsh and its usage
https://www.howtogeek.com/362409/what-is-zsh-and-why-should-you-use-it-instead-of-bash/
- Create Shell aliases & suffix aliases
- cat ~/.zsh_histry | grep - C # To see most uses commands and create alias
- what is suffix alias ? use command line to opening a file (e.g) openning .png file in photo viewer

## 1.2. Add alias in Git
```
 Path to add in Git installation = ./git/etc/bash.bashrc

alias gs="git status"
alias gco="git checkout"
alias gcm="git commit -m"
alias ga="git add"
alias gps="git push origin "
alias gpl="git pull origin "
alias gf="git fetch"
alias gfp="git fetch -p"
alias gsh="git stash save "
alias glst="git stash list "
alias gpop="git stash pop "
alias glog="git log --oneline --graph"

// docker commands

alias dcls='docker container ls'
alias dclsa='docker container ls -a'
alias dcrm='docker container rm '
alias dcrma='docker rm $(docker ps -a -q)'
alias dimgs='docker images'


```  
## 1.3. Productivity videos  
- [unix-command-line-productivity](https://blog.sebastian-daschner.com/entries/unix-command-line-productivity)

- [zsh-aliases](https://blog.sebastian-daschner.com/entries/zsh-aliases)

- [effective-keyboard-usage-video](https://blog.sebastian-daschner.com/entries/effective-keyboard-usage-video-course)

- [dotfiles](https://github.com/sdaschner/dotfiles)

- [ubuntu-linux-tips](https://www.addictivetips.com/ubuntu-linux-tips/beginners-guide-i3-window-manager/)

 # 2. Useful extensions
 - [Markdown-editor](https://marketplace.visualstudio.com/items?itemName=yzhang.markdown-all-in-one)
 - [Intellj Features](https://blog.sebastian-daschner.com/entries/13-lesser-known-intellij-features)

# 3. Useful Plugin Visual Studio
```
Name: IntelliJ IDEA Keybindings
Id: k--kato.intellij-idea-keybindings
k--kato.intellij-idea-keybindings

----
Name: Gradle for Java
Id: vscjava.vscode-gradle
Description: Manage Gradle Projects, run Gradle tasks and provide better Gradle file authoring experience in VS Code
Version: 3.12.5
Publisher: Microsoft
VS Marketplace Link: https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-gradle

----
Name: Spring Initializr Java Support
Id: vscjava.vscode-spring-initializr
Description: A lightweight extension based on Spring Initializr to generate quick start Spring Boot Java projects.
Version: 0.11.1
Publisher: Microsoft
VS Marketplace Link: https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-spring-initializr
```
