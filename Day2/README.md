# Day 2

## Lab - Create a depot with 2 levels of depth
```
cd /home/jegan
mkdir -p projects
cd projects
git clone https://github.com/tektutor/multi-module-project
cd multi-module-project
rm -rf .git
cd ..
```

Let's create a stream depot, make sure the depot depth is 2
```
export P4PORT=localhost:1666
export P4USER=super
p4 login

p4 depot -t stream projects
```

Let's create a stream of type mainline under depot projects
```
p4 stream -t mainline //projects/tektutor/main
```

Let's create a client workspace
```
export P4CLIENT=projects_ws
p4 client -S //projects/tektutor/main
```

Let's add the files
```
cd /home/jegan/projects
p4 add multi-module-project/...
p4 submit
```

## Lab - Deleting depot that has files in it
In order to delete the depot that has files, we first need to delete the client workspaces

```
export P4PORT=localhost:1666
export P4USER=super
export P4CLIENT=jegan_ws

p4 login
p4 clients
p4 client -d jegan_ws
```

Let's delete the stream associated with the depot
```
p4 streams //myprojects/...
p4 stream --obliterate -y //myprojects/main
```

Let's delete all the files in the depot
```
p4 obliterate -y //myprojects/main/...
```

Let's now delete the depot
```
p4 depot -d myprojects
```

## Lab - Mapping multiple depots into a single workspace

Clone the TekTutor Perforce Training Repository
```
cd ~
git clone https://github.com/tektutor/perforce-may-2024.git
```

Let's create our first stream depot
```
export P4PORT=localhost:1666
export P4USER=super
p4 login

cd ~/perforce-may-2024
git pull

cd Day2
cat depot1-depth1.txt | p4 depot -i
```

Let's create our ond stream depot
```
cd ~/perforce-may-2024
cd Day2
cat depot2-depth2.txt | p4 depot -i
```

Let's list the depots to see if the depots are created
```
p4 depots
p4 depot -o projects1
p4 depot -o projects2
```

Let's create mainline stream under projects1 depot you need to edit stream1-project1.txt file before proceeding to customize as per your preference)
```
cd ~/perforce-may-2024
cd Day2
cat stream1-project1.txt | p4 stream -i
```

Let's create mainline stream under projects2 depot ( you need to edit stream2-project2.txt file before proceeding to customize as per your preference)
```
cd ~/perforce-may-2024
cd Day2
cat stream2-project2.txt | p4 stream -i
```

Let's verify if the streams are created as per our requirements
```
p4 streams
p4 stream -o //projects1/main
p4 stream -o //projects2/tektutor/main
```

We need to create workspace to upload files into project1 and project2 depots.

First let's create the workspace
```
cd ~/perforce-may-2024
git pull
cd Day2
cat projects1-workspace.txt | p4 client -i
cat projects2-workspace.txt | p4 client -i
```

Let's push source code into projects1 depot
```
cd ~
mkdir projects1
cd projects1
git clone https://github.com/tektutor/spring-ms.git
cd spring-ms
rm -rf .git
cd ../..

p4 set P4CLIENT=projects1_ws
p4 add projects1/...
p4 submit
```

Let's push source code into projects2 depot
```
cd ~
mkdir projects2
cd projects2
git clone https://github.com/tektutor/multi-module-project.git
cd multi-module-project
rm -rf .git
cd ../..

p4 set P4CLIENT=projects2_ws
p4 add projects2/...
p4 submit
```

You can launch p4v and check if the files are populated into projects1 and projects2 depots as expected.

Now let's create a workspace and map both these depots into it.

```
cd ~/perforce-may-2024
git pull
cd Day2

cat myworkspace.txt | p4 client -i
p4 clients
p4 client -o jegan_ws
```

Let's switch to /home/jegan/projects( This is the root folder the jegan_ws points to ). This would be empty as of now. Hence, we to sync it
```
p4 set P4CLIENT=jegan_ws
p4 sync
```

## Lab - Find all the changelists in pending state
```
p4 changes -s pending
```

## Lab - Find all the changelists in submitted state
```
p4 changes -s submitted
```

## Lab - Find all the changelists in shelved state
```
p4 changes -s shelved
```

## Lab - Using filelog
```
p4 filelog //myprojects/dev1.0/fruits.txt
```

## Lab - Using fstat
```
p4 fstat //myprojects/dev1.0/fruits.txt
```

## Lab - Using diff
```
p4 diff2 //myprojects/dev1.0/fruits.txt#1 //myprojects/dev1.0/fruits.txt#2
```

## Lab - Creating dev stream using CLI command
```
p4 depot -t stream test-depot
p4 stream -t mainline //test-depot/main

cd ~
mkdir ~/test
cd test

p4 client -s -S //test-depot/main 

p4 stream -t development -P //test-depot/main //test-depot/dev1.0
```

## Lab - Populating workspace from commandline
```
p4 populate -r -S //test-depot/rel1.0
p4 sync
```
