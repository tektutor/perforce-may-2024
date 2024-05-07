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
p4 --obliterate -y //myprojects/main/...
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


