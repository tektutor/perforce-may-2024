# Day 4

## Lab - Tag depot 
```
p4 tag -l v1.0 //myprojects/rel-1.0/...
```

## Lab - Tag files in a changelist
```
p4 tag -l v2.0 //myprojects/dev-1.0/...@15
```

## Lab - Listing files that has a specific label tag
```
p4 files @v1.0p4 shelve -c 77 ....html "*.c" "*.java"
```

Expected output
<pre>
p4 files @v1.0
//myprojects/rel-1.0/spring-ms/pom.xml#3 - edit change 16 (text)
//myprojects/rel-1.0/spring-ms/src/main/java/com/example/springboot/Application.java#1 - branch change 14 (text)
//myprojects/rel-1.0/spring-ms/src/main/java/com/example/springboot/HelloController.java#1 - branch change 14 (text)  
</pre>


## Lab - Revert uncommitted changes made in workspace
Find all the files that were modified in the workspace 
```
export P4CLIENT=super_perforce-server-1_rel-1.0_3201
p4 opened
p4 opened -a
```

Let's discard the changes done in workspace by using revert
```
p4 revert //myprojects/rel-1.0/spring-ms/pom.xml
```

## Lab - Perforce shelve
What it does ? - Stores files from a pending changelist in the depot without submitting them

What it is the use ? - You can temporarily store the changes you did in Perforce server without committing your changes

Find which changelists are in pending status (i.e - changelist that are yet to be submitted )
```
p4 changes -s pending
```

Find the revisions of a file
```
p4 filelog //myprojects/rel-1.0/spring-ms/pom.xml
```

Now let's shelve these changes in perforce depot without committing them
```
p4 shelve -c 20
```

## Lab - unshelve shelved changes to resume working in workspace

This is useful to resume working on bug fix changes that were parked earlier in depot.

Find all the shelved changes
```
p4 changes -s pending
p4 revert
```

Unshelve them now ( in the below 20 is the changelist number that was previously shelved
```
p4 unshelve -S 20
```

## Lab - Display information about changelist
```
p4 changes
p4 describe 21
```

## Lab - Undo submitted changes
```
p4 changes
p4 undo @16
```

## Lab - Diff
```
p4 files //myprojects/rel-1.0/...
p4 diff //myprojects/rel-1.0/spring-ms/pom.xml#3 //myprojects/rel-1.0/spring-ms/pom.xml#1
```

## Lab - Backup and Recovery or Moving Perforce server from one machine to another
```
https://ftp.perforce.com/perforce/r16.2/doc/manuals/p4sag/appendix.moving.html
```

Find the perforce server's root folder
```
p4 info
```

On the old(source) server as administrator, navigate to perforce server root folder. This will create a checkpoint file (text)
```
cd /opt/perforce/sbin
./p4d -r /opt/perforce/servers/perforce-server-1/root -jc
```

Expected output
<pre>
root@perforce-server-1:/opt/perforce/sbin# ./p4d -r /opt/perforce/servers/perforce-server-1/root -jc
Checkpointing to ../journals/perforce-server-1.ckp.1...
MD5 (../journals/perforce-server-1.ckp.1) = B079826BA9AD6A716E2E56FB187FF85C
Rotating ../journals/journal to ../journals/perforce-server-1.jnl.0...  
</pre>

You need to copy the checkpoint file to the new server to recover/migrate from /opt/perforce/servers/perforce-server-1/journals and the file name is perforce-server-1.ckp.1.  The checkpoint file will be named against your perforce server serverid.

On the new(destination) server as administrator, navigate to perforce server root folder. 
```
p4 admin stop

mv your_root_dir/db.* /tmp

p4 admin start


cd /opt/perforce/sbin
./p4d -r $P4ROOT -jr checkpoint_file journal_file
```

## Lab - Multi-site Perforce installation

We need atleast 2 linux machines.  On, one of the linux machines we will run the Perforce server and on the linux machine we will setup helix proxy server.  In my case, the ubuntu virtual machine will act like a helix proxy server.

To install helix proyx server2
```
sudo apt-get install helix-proxy -y
```

Expected output
<pre>
root@perforce-server-2:/# apt-get install helix-proxy -y
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
The following additional packages will be installed:
  helix-proxy-base
The following NEW packages will be installed:
  helix-proxy helix-proxy-base
0 upgraded, 2 newly installed, 0 to remove and 9 not upgraded.
Need to get 3,491 kB of archives.
After this operation, 8,160 kB of additional disk space will be used.
Get:1 http://package.perforce.com/apt/ubuntu focal/release amd64 helix-proxy-base amd64 2023.2-2578891~focal [3,483 kB]
Get:2 http://package.perforce.com/apt/ubuntu focal/release amd64 helix-proxy amd64 2023.2-2578891~focal [7,796 B]
Fetched 3,491 kB in 4s (952 kB/s)
Selecting previously unselected package helix-proxy-base.
(Reading database ... 153770 files and directories currently installed.)
Preparing to unpack .../helix-proxy-base_2023.2-2578891~focal_amd64.deb ...
Unpacking helix-proxy-base (2023.2-2578891~focal) ...
Selecting previously unselected package helix-proxy.
Preparing to unpack .../helix-proxy_2023.2-2578891~focal_amd64.deb ...
Unpacking helix-proxy (2023.2-2578891~focal) ...
Setting up helix-proxy-base (2023.2-2578891~focal) ...
Setting up helix-proxy (2023.2-2578891~focal) ...
linking /opt/perforce/sbin/p4p to /usr/sbin/p4p

::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
::  Thank you for choosing Perforce Helix
::  The following has been installed by the 'helix-proxy' package:
::
::  - The Helix Proxy (p4p)
::  - A 'perforce' system user
::  - p4dctl, a tool for managing Perforce service instances
::  - The Helix Command-Line Client (p4)
::
::  The Helix Proxy is now installed, but not yet configured.
::  To configure a new Proxy instance, copy the p4dctl Proxy
::  template to a new file, fill in the placeholders and make the
::  Proxy root directory.
::
::    sudo -u perforce sh -c \
::      "cp /etc/perforce/p4dctl.conf.d/p4p.template \
::          /etc/perforce/p4dctl.conf.d/p4p-master.conf; \
::      mkdir /opt/perforce/servers/p4p-master"
::
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

Started 0 services.
Processing triggers for man-db (2.12.0-4build2) ...
</pre>

We need to configure helix proxy server on server 2
```
mkdir -p /var/proxyroot
p4p -p tcp64:[::]:1999 -t 172.20.10.5:1666 -r /var/proxyroot
```
