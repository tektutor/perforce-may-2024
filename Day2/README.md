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
