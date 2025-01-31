#   Linux

----------------------------------------------------------------

##  1) History of linux
-   opensource (linux kernel) - linus torvalds (developed by thousand of programmers)
-   OS: intermediate b/w hardware and apps (provides services to apps and programs)
	-  file management (layout - hardware)
    -  memory management
    -  i/o and output management
    -  manage resources(memory, cpu) for running apps
-   **Operating systems:**
    -  1940's (mid) - first computers - vacuum tubes - evacuated glass containers (control electric current) - like switches (large in size)
    -  programming done manually (move tubes) - limited i/o (direct interaction: heavy lifting)
    -  programmer is the operator
    -  **Transistor:**
       -  beginning of OS: IBM punched cards (program cloth - holding data)
       -  data: presence and absence of holes (read from top left - vertically)
       -  5Mn data - 62500 punch cards needed
-   **Unix genesis:**
    -  Most advanced OS of its time - many modern concepts still used
    -  IC, magnetic discs, compatible computers: IBM
    -  IBM(1964) - announced clear distinction b/w architecture and implementation
-   **MAC project:**
    -  MAC project on math and computation founded by MIT funded by US military research funding agency (ARPA) and US national science foundation
    -  Aim: realise time-sharing system - allow wide community of users to simultaneously access hardware and software resources of a single computer from multiple locations
    -  developed multics - multiplexed information and computing service
    -  send multiple pieces of information over a common channel (single complex signal): share resources b/w multiple users
    -  no longer just resource sharing (evolved) - file sharing, management, security
    -  **MAC Bell labs and general electric:**
       -  general electric: built underlying system, bell labs: OS design, later bell labs resigned -> group (dennis ritchie - led different path)
       -  build minimal path system - single user OS (bell labs doesn't back this plan) - A pun of multics called Unics
       -  1970 - plan changed (single user to multiple user OS) - Unix(morphed)
       -  system written in B language (Kem thomson) - changes B (way to C - Dennis Ritchie) -> Improved C - unix upgraded
       -  open source versions (set to universities) -> various unix versions
       -  ken and dennis - received turing award
       -  mac, android, even linux: based on unix
    -  **Unix:**
       -  1980 - widely adopted by universities and research institutions, startup and companies
       -  1983: truing award to ken and dennis
       -  same 1983 - Richard stallman launched GNU project (MIT launched)
    -  **GNU:**
       -  Recursive acronym: GNU's not unix (referred to itself) - open source, free, collaborative, provide software compatible with unix
       -  Unix was owned by bell labs (sells license), GNU - free
       -  GNU had much software (text editors, GUI, GCC compiler)
       -  issue: run these software on Unix -> (proprietary)
    -  **Linus torvalds:**
       -  21 years old Finnish CS student -> frustration(limited) -> messaged community (free OS - hobby project) -> later became the linux kernel
       -  meant to run on PC 83.86 processors, development done using GNU C Compiler (main choice) - compiling linux
       -  1992 - first linux distribution (OS, collection of free GNU editor, compiler, library)
       -  90s: IBM, Dell, HP: announced compatible with linux (run web servers: 70% market share), 90% (android OS based on linux)
       -  dominating super computers, film and special effects (99% share)


##  2) **Command line interface:**
>   me@linuxbox-> user/computer/current_directory
-   **Shell:**
    -  command line interpreter (CLI) - user types command, shell interprets and executes
    -  **Bash:** enhanced version of shell - default shell in most linux distributions
    -  **Shell scripting:**
       -  automate tasks (repetitive tasks)
       -  sequence of commands (shell script)
       -  **Shell script:** text file (executable) - interpreted by shell
    -  **Shebang:**
       -  first line: #!/bin/bash (tells shell to execute script)
       -  **Example:**
          -  #!/bin/bash
          -  echo "Hello, World!"
```bash
commands: 
    > whoami -> username
    > whoami --help -> show help document
    > id -> user id (uid, gid, groups)
    > logname -> print current user
    > echo hello -> print hello
    > echo $0 -> print sh: shell (not: $0)
    > hostname -> who is the host
    > uname -> name of the system
    > histroy
    > up arrow: previously entered commands
    > clear
    > uptime
    > cal -> display calculator
    > date -> current date and time
    > date +%d -> day, %m -> month, %y -> year
    > man -> manual page (show documentation)
    > pwd -> print current directory
    > ls -> print list of files and folders in current directory
    > cd -> change directory
    > ls -a -> show hidden files also
    > ls -al -> detailed view of files and folders
    > touch -> create a file
    > rm -> remove a file
    > cat hello.txt
    > echo "hello" > hello.txt (save "hello" to hello.txt)
    > cat file.txt filecpy.txt (copy one file to other)
    > cat /etc/services > list.txt (view o/p in the file)
    > cat /etc/services | more (can opt for more o/p)
    > cat /etc/services | less (scroll for more)
    > more hello.txt (can use space)
    > less hello.txt
    > mkdir folder_name
    > rmdir folder_name (empty)
    > rm -r folder (Recursive - delete all files)
    > rm -ri folder (interactive - ask whether to delete for each file)
    > yes | rm -ri folder (yes to all asks)
    > mkdir -p d1/d2/d3/d4/d5 (using mkdir if d4 not found, can\'t create d5, using -p: creates both)
    > mv source destination
    > mv hello.text hi.text (rename - if not exists)
    > cp file1.txt hello.txt or cat file1.txt > hello.txt
    > cp -r directory1 directory2 (copy all files)
    > find / -i path "*joe*" > dev/null (ignore lower case, move to bin)
    > diff file1.txt file2.txt (compare two files)
    > diff -wy file1.txt file2.txt (ignore whitespaces)
    
    options:
    - i: interactive
    - f: don't prompt, just warn
    - n: don't override
    
    create file:
    > touch 'hello world.txt'
    
    search file:
    > echo p* (list all folders/ files starting with p)
    > echo a?? (3 letters, start with a)
    > find / (list all directories and files)
    > find . -name "prog" (starting with prog)
    > find . -name "prog" 2 > file.txt (ignore errors, write to a file)
    

    paths:
    > .. -> parent directory
    > cd ..
    > cd ../..
    > cd ./sys or cd sys (same directory)
    
    Interactive commands
    > top: cpu usage
    > htop: more design (graphical top)
    > nano: file editor
    > vim: file editor
    > ge
    
    > hello
    > worm
    > firework (simulation)
    > rain (simulation)
    > hanoi (play towers of hanoi)
    > knight -> solitaire game
    
    nano:
    > file f (ascii text)
    > realpath f (show real path)
    > which realpath -> some files link to others
    
    memory:
    > free [-b/k/m/g]: byte, kb, mb, gb -> show memory usage
    > top (all running programs - filter, sort), htop: visual
    
    redirect to other file:
    > use > or | (pipe)
    
    give input
    > ./program < file1.txt
```
-   **File system hierarchy:**
    -  /bin: basic commands (start, use minimal system -> .exe file)
    -  /sbin: root user
    -  /home: all users home
    -  /root: root user home
    -  /etc: config files
    -  /lib: store software libraries (req for .exe files)
    -  /tmp: temp files (/var/tmp or /run/tmp)
    -  /var: various files used by os (DB, email, history, logs)
    -  /usr: unix system resources (user apps, libraries, documentation), subfolders
    -  /usr/bin: .exe files (not must for minimal system)
    -  /dev: files corresponds directly / indirectly to a physical device
    -  /etc/services: all services of the OS
    -  /dev/null: black hole or bin -> lost forever

-  **Strength of linux:**
   -  consider everything as files - including devices (/dev/printer, /dev/audio, /dev/mem, /dev/network_card)

-   **Compile C language:**
```c
    > gcc -std=c11 -Wall -fmax -errors=10 -Wextra program.c -o program
    > exec ./program
``` 
-   **Problems with scanf:**
    -  whenever space - split the input
    -  use fgets, getline, gnureadline (linux)
    -  