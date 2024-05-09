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
