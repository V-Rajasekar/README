# Installation support for other softwares

## Installation guides
[Dotnet/Core ASP .Net](https://learn.microsoft.com/en-gb/dotnet/core/install/linux-ubuntu-2204)

#### Install gradle in Ubuntu

```shell
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install gradle
```

#### Install Software in Mac

Homebrew is a package manager for macOS that makes it easy to install software. If you don’t have Homebrew installed, you can install it using the
following command in your terminal:

`/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`

- Installing Jmeter
  - `brew install jmeter`
  - To open Jmeter GUI: `jmeter`
- Installing Jenv
  - `brew install jenv`
  - Add JDKs to jenv
    - `jenv add /Library/Java/JavaVirtualMachines/zulu-17.jdk/Contents/Home eval "$(jenv init -)"`
    - `jenv add /Library/Java/JavaVirtualMachines/zulu-11.jdk/Contents/Home eval "$(jenv init -)"`
  - List java versions added in jenv `jenv versions`
  - To see configured java version in local `jenv version`    
  - Go to the local folder (e.g) repo path and set the desired java version like  `jenv local 11`
  - [Jenv ReadMe](https://github.com/jenv/jenv)

####

