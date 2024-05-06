# Day 1

## Installing Perforce Server in CentOS/RHEL 9.x
```
sudo rpm --import https://package.perforce.com/perforce.pubkey
```

Create a file /etc/yum.repos.d/perforce.repo with below content and save it as Administrator
```
[perforce]
name=Perforce
baseurl=http://package.perforce.com/yum/rhel/9/x86_64
enabled=1
gpgcheck=1
```

Install Perforce server
```
sudo yum install helix-p4d -y
```

## Installing Perforce Server in SUSE Linux Enterprise Server
```
sudo rpm --import http://package.perforce.com/perforce.pubkey
sudo zypper addrepo http://package.perforce.com/yum/rhel/7/x86_64/ helix
sudo zypper install helix-p4d
```


## Installing Perforce Server in Ubuntu
For detailed instructions, refer the official page at below URL
```
https://www.perforce.com/downloads/helix-core-p4d
```

For quick steps to install Perforce
```
sudo -i

wget https://package.perforce.com/perforce.pubkey
gpg -n --import --import-options import-show perforce.pubkey
gpg -n --import --import-options import-show perforce.pubkey | grep -q "E58131C0AEA7B082C6DC4C937123CB760FF18869" && echo "true"
wget -qO - https://package.perforce.com/perforce.pubkey | sudo apt-key add -
```

As Administrator, create a file named /etc/apt/sources.list.d/perforce.list with the below content and save it
```
deb http://package.perforce.com/apt/ubuntu focal release
```

Now, let's start the Perforce installation
```
sudo apt update
apt-get install helix-p4d -y
```

Expected output
<pre>
jegan@tektutor.org:~/Downloads$ sudo -i
  
root@tektutor.org:~# wget https://package.perforce.com/perforce.pubkey
--2024-05-01 16:22:42--  https://package.perforce.com/perforce.pubkey
Resolving package.perforce.com (package.perforce.com)... 54.151.26.160
Connecting to package.perforce.com (package.perforce.com)|54.151.26.160|:443... connected.
HTTP request sent, awaiting response... 200 OK
Length: 1704 (1.7K)
Saving to: ‘perforce.pubkey’

perforce.pubkey                  100%[=========================================================>]   1.66K  --.-KB/s    in 0s      

2024-05-01 16:22:44 (246 MB/s) - ‘perforce.pubkey’ saved [1704/1704]

root@tektutor.org:~# gpg -n --import --import-options import-show perforce.pubkey
gpg: keyblock resource '/root/.gnupg/pubring.kbx': No such file or directory
pub   rsa4096 2013-08-16 [SC] [expires: 2026-06-12]
      E58131C0AEA7B082C6DC4C937123CB760FF18869
uid                      Perforce Software (Package Signing) <support+packaging@perforce.com>

gpg: Total number processed: 1
  
root@tektutor.org:~# gpg -n --import --import-options import-show perforce.pubkey | grep -q "E58131C0AEA7B082C6DC4C937123CB760FF18869" && echo "true"
gpg: keyblock resource '/root/.gnupg/pubring.kbx': No such file or directory
gpg: Total number processed: 1
true
  
root@tektutor.org:~# wget -qO - https://package.perforce.com/perforce.pubkey | sudo apt-key add -
Warning: apt-key is deprecated. Manage keyring files in trusted.gpg.d instead (see apt-key(8)).
OK
  
root@tektutor:~# vim /etc/apt/sources.list.d/perforce.list
  
root@tektutor:~# apt update
Get:1 https://dl.google.com/linux/chrome/deb stable InRelease [1,825 B]
Hit:2 http://in.archive.ubuntu.com/ubuntu noble InRelease                                                                         
Hit:3 http://in.archive.ubuntu.com/ubuntu noble-updates InRelease                                                                 
Get:4 http://package.perforce.com/apt/ubuntu focal InRelease [7,646 B]                    
Get:5 https://dl.google.com/linux/chrome/deb stable/main amd64 Packages [1,083 B]                      
Hit:6 http://security.ubuntu.com/ubuntu noble-security InRelease                
Hit:7 http://in.archive.ubuntu.com/ubuntu noble-backports InRelease
Get:8 http://package.perforce.com/apt/ubuntu focal/release amd64 Packages [34.5 kB]
Fetched 45.0 kB in 2s (27.6 kB/s)   
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
All packages are up to date.
W: http://package.perforce.com/apt/ubuntu/dists/focal/InRelease: Key is stored in legacy trusted.gpg keyring (/etc/apt/trusted.gpg), see the DEPRECATION section in apt-key(8) for details.
root@tektutor:~# apt update
Hit:1 https://dl.google.com/linux/chrome/deb stable InRelease
Hit:2 http://security.ubuntu.com/ubuntu noble-security InRelease                                   
Hit:3 http://in.archive.ubuntu.com/ubuntu noble InRelease                                          
Hit:4 http://package.perforce.com/apt/ubuntu focal InRelease
Hit:5 http://in.archive.ubuntu.com/ubuntu noble-updates InRelease
Hit:6 http://in.archive.ubuntu.com/ubuntu noble-backports InRelease
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
All packages are up to date.
W: http://package.perforce.com/apt/ubuntu/dists/focal/InRelease: Key is stored in legacy trusted.gpg keyring (/etc/apt/trusted.gpg), see the DEPRECATION section in apt-key(8) for details.
root@tektutor:~# apt-get install helix-p4d
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
The following additional packages will be installed:
  helix-cli helix-cli-base helix-p4d-base helix-p4d-base-23.2 helix-p4dctl net-tools
The following NEW packages will be installed:
  helix-cli helix-cli-base helix-p4d helix-p4d-base helix-p4d-base-23.2 helix-p4dctl net-tools
0 upgraded, 7 newly installed, 0 to remove and 0 not upgraded.
Need to get 14.6 MB of archives.
After this operation, 33.1 MB of additional disk space will be used.
Do you want to continue? [Y/n] Y
Get:1 http://package.perforce.com/apt/ubuntu focal/release amd64 helix-cli-base amd64 2023.2-2578891~focal [4,652 kB]
Get:2 http://in.archive.ubuntu.com/ubuntu noble/main amd64 net-tools amd64 2.10-0.1ubuntu4 [204 kB]
Get:3 http://package.perforce.com/apt/ubuntu focal/release amd64 helix-cli amd64 2023.2-2578891~focal [7,148 B]                   
Get:4 http://package.perforce.com/apt/ubuntu focal/release amd64 helix-p4dctl amd64 2023.2-2578891~focal [1,930 kB]               
Get:5 http://package.perforce.com/apt/ubuntu focal/release amd64 helix-p4d-base-23.2 amd64 2023.2-2578891~focal [7,829 kB]        
Get:6 http://package.perforce.com/apt/ubuntu focal/release amd64 helix-p4d-base amd64 2023.2-2578891~focal [3,268 B]              
Get:7 http://package.perforce.com/apt/ubuntu focal/release amd64 helix-p4d amd64 2023.2-2578891~focal [23.9 kB]                   
Fetched 14.6 MB in 54s (269 kB/s)                                                                                                 
Selecting previously unselected package helix-cli-base.
(Reading database ... 151785 files and directories currently installed.)
Preparing to unpack .../0-helix-cli-base_2023.2-2578891~focal_amd64.deb ...
Unpacking helix-cli-base (2023.2-2578891~focal) ...
Selecting previously unselected package helix-cli.
Preparing to unpack .../1-helix-cli_2023.2-2578891~focal_amd64.deb ...
Unpacking helix-cli (2023.2-2578891~focal) ...
Selecting previously unselected package helix-p4dctl.
Preparing to unpack .../2-helix-p4dctl_2023.2-2578891~focal_amd64.deb ...
Unpacking helix-p4dctl (2023.2-2578891~focal) ...
Selecting previously unselected package helix-p4d-base-23.2.
Preparing to unpack .../3-helix-p4d-base-23.2_2023.2-2578891~focal_amd64.deb ...
Unpacking helix-p4d-base-23.2 (2023.2-2578891~focal) ...
Selecting previously unselected package helix-p4d-base.
Preparing to unpack .../4-helix-p4d-base_2023.2-2578891~focal_amd64.deb ...
Unpacking helix-p4d-base (2023.2-2578891~focal) ...
Selecting previously unselected package net-tools.
Preparing to unpack .../5-net-tools_2.10-0.1ubuntu4_amd64.deb ...
Unpacking net-tools (2.10-0.1ubuntu4) ...
Selecting previously unselected package helix-p4d.
Preparing to unpack .../6-helix-p4d_2023.2-2578891~focal_amd64.deb ...
Unpacking helix-p4d (2023.2-2578891~focal) ...
Setting up net-tools (2.10-0.1ubuntu4) ...
Setting up helix-cli-base (2023.2-2578891~focal) ...
Setting up helix-p4d-base-23.2 (2023.2-2578891~focal) ...
update-alternatives: using /opt/perforce/sbin/p4d.23.2 to provide /opt/perforce/sbin/p4d (helix-p4d) in auto mode
Setting up helix-cli (2023.2-2578891~focal) ...
linking /opt/perforce/bin/p4 to /usr/bin/p4
Setting up helix-p4dctl (2023.2-2578891~focal) ...
Setting up helix-p4d-base (2023.2-2578891~focal) ...
Setting up helix-p4d (2023.2-2578891~focal) ...
linking /opt/perforce/sbin/p4d to /usr/sbin/p4d

::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
::  Thank you for choosing Perforce Helix Core Server (p4d)
::  The following has been installed by the 'helix-p4d' package:
::
::  - The Helix Core Server (p4d)
::  - A 'perforce' system user
::  - p4dctl, a tool for managing Perforce service instances
::  - The Helix Command-Line Client (p4)
::
::  The Helix Core Server (p4d) is now installed, but not yet configured.
::  You must run the following to configure p4d (as root):
::
::    sudo /opt/perforce/sbin/configure-helix-p4d.sh
::
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

Started 0 services.
No services configured.
Processing triggers for man-db (2.12.0-4build2) ...
root@tektutor.org:~#   
</pre>

## Configuring ServerID for your Helix Perforce Server

Stopping perforce server in case it is already running
```
sudo systemctl stop helix-p4dctl.service
```

Expected output
<pre>
jegan@tektutor.org:~$ sudo -i
root@tektutor.org:~# /opt/perforce/sbin/configure-helix-p4d.sh perforce

Summary of arguments passed:

Service-name        [perforce]
P4PORT              [(not specified)]
P4ROOT              [(not specified)]
Super-user          [(not specified)]
Super-user passwd   [(not specified)]
Unicode mode        [(not specified)]
Case-sensitive      [(not specified)]

For a list of other options, type Ctrl-C to exit, and then run:
$ sudo /opt/perforce/sbin/configure-helix-p4d.sh --help


You have entered interactive configuration for p4d. This script
will ask a series of questions, and use your answers to configure p4d
for first time use. Options passed in from the command line or
automatically discovered in the environment are presented as defaults.
You may press enter to accept them, or enter an alternative.

Please provide the following details about your desired Perforce environment:


Perforce Service name [perforce]: 
Service perforce not found. Creating...
Perforce Server root (P4ROOT) [/opt/perforce/servers/perforce]: 
Create directory? (y/n) [y]: y
Perforce Server unicode-mode (y/n) [n]: y
Perforce Server case-sensitive (y/n) [y]: y
Perforce Server address (P4PORT) [ssl:1666]: localhost:1666
Perforce super-user login [super]: 
Perforce super-user password: 
Re-enter password.
Perforce super-user password: 

Configuring p4d service 'perforce' with the information you specified...

Perforce db files in '/opt/perforce/servers/perforce/root' will be created if missing...
Server switched to Unicode mode.
Started 'perforce' p4d service.
Started 1 services.
Creating super-user account...
User super not changed.
Initializing protections table...
Protections saved.
Setting security level to 3 (high)...
Counter security set.
Setting password...
Creating ticket for root user
Also creating ticket for calling user 'jegan'.


::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
::  P4D configuration has completed successfully.
::
::  Here is what has been done so far:
::
::  - Your p4d service settings have been written to 
::    the following p4dctl configuration file:
::      /etc/perforce/p4dctl.conf.d/perforce.conf
::  - The p4d service has been initialized with the P4ROOT:
::      /opt/perforce/servers/perforce/root
::  - The p4d service has been started with the P4PORT: localhost:1666
::  - The p4d service has been set to Security Level 3.
::  - The new Perforce super-user 'super' has been created and the
::    password has been set to the one specified.
::
::  Here is what you can do now:
::
::  - You can manage it with the 'perforce' user, using the following:
::
::      sudo -u perforce p4dctl <cmd> 
::
::  - You can connect to it by setting the P4PORT and P4USER
::    environment variables and running 'p4 <cmd>'. For example, run:
::
::      export P4PORT=localhost:1666
::      export P4USER=super
::
::      p4 login
::
::    For help, run:
::
::      p4 help
::
::  - To connect to this p4d service from another machine, include
::    this machine's name or IP address in the P4PORT. For example:
::
::      export P4PORT=192.168.1.104:1666
::
::  - For help with creating Perforce Helix user accounts, populating
::    the depot with files, and making other customizations for your
::    site, see the Helix Versioning Engine Administrator Guide:
::
::    https://www.perforce.com/perforce/doc.current/manuals/p4sag/index.html
::
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

</pre>

## Installing Perforce Visual and CLI client
```
https://www.perforce.com/downloads/helix-visual-client-p4v
```

Troubleshooting p4v client launch
<pre>
jegan@tektutor.org:~/p4v-2024.1.2573667/bin$ ./p4v
qt.qpa.plugin: From 6.5.0, xcb-cursor0 or libxcb-cursor0 is needed to load the Qt xcb platform plugin.
qt.qpa.plugin: Could not load the Qt platform plugin "xcb" in "" even though it was found.
This application failed to start because no Qt platform plugin could be initialized. Reinstalling the application may fix this problem.

Available platform plugins are: vnc, xcb, vkkhrdisplay, offscreen, minimal.

Aborted (core dumped)  
</pre>

You need to install
```
sudo apt-get install libxcb-cursor0
```

## What is Perforce Repository?
- container of Perforce depots
- one Perforce manages just one Perforce Repository

## What is Perforce Depot?
- Perforce repository has one to many Depots
- directory structure where Perforce manages the changes done in your project source code
- can have many subfolders

## What is Perforce workspace?

## What is Perforce changelist?

## Types of Depot
- local
- remote
- stream

## Lab - Finding server configuration details
```
p4 info
```

## Lab - Listing depots in your Perforce Repository
```
p4 depots
```

## Lab - Creating a stream depot
```
p4 depots
p4 depot -t stream myprojects
p4 depots
```

## Lab - Create a workspace and bind it with your stream
```
export P4CLIENT=jegan_ws
p4 client -S //myprojects/main
```
