# Day 3

## Lab - Print a depot file revisions also prints content changes done
```
p4 depots
p4 print  -a //myprojects/...
```

## Lab - Print revisions of a specific file in a depot also prints content changes done
```
p4 print  -a //myprojects/main/fruits.txt

p4 print -m 2 -a //myprojects/main/fruits.txt#1
p4 print -m 2 -a //myprojects/main/fruits.txt#2
p4 print -m 2 -a //myprojects/main/fruits.txt#3
p4 print -m 2 -a //myprojects/main/fruits.txt#4
```

## Lab - Print revisions of files in a depot without accessing the content of the files
```
p4 files  -a //myprojects/main/fruits.txt
```

## Lab - Print revisions of files in a depot without accessing the content of the files
```
p4 files //myprojects/main/fruits.txt
p4 files //myprojects/dev1.0/fruits.txt
```

## Lab - Prints sub-directories that appear immediately under the depot one level depth
```
p4 dirs //test-depot/*
```

## Lab - Prints sub-directories that appear two devels down the depot
```
p4 dirs //test-depot/*/*
```

## Lab - Print description of changelist, with list of affected files and their diffs
```
p4 changes
p4 describe 6
```

## Lab - Prints each line of the file along with the revision details when each of those line were introduced
```
p4 annotate -c //myprojects/dev1.0/fruits.txt
```

## Lab - Creating perforce user
```
p4 user -f sriram
p4 passwd sriram
p4 user -f jegan
p4 passwd jegan
```

Attempt to login as sriram, it won't allow sriram to login
```
export P4USER=sriram
p4 login
```

Attempt to login as jegan, it won't allow jegan to login
```
export P4USER=jegan
p4 login
```

We need enable restricted access to sriram and jegan with p4 protect command.

## Lab - Creating user group called 'admins'
```
p4 group admins
```

Update the  group definition as shown below
<pre>
Group:	admins
Description:
	Only these users will be able to perform user management

MaxResults:		unlimited
MaxScanRows:		unlimited
MaxLockTime:		unlimited
MaxOpenFiles:		unlimited
MaxMemory:		unlimited
Timeout:		43200
PasswordTimeout:	unlimited
Subgroups:
Owners:
Users:
	jegan
	super	
</pre>


## Lab - Configuring Perforce Protection table
The perforce server protection table has a default entry as shown below
```
write user * * //...
```

What it means is, it implies which all users has write permission
<pre>
First * - any user
Second * - from any host/machine
//... - all depots	
</pre>	

So, we understand any user from any machine has read/write access to all the depots in the Perforce server.
We can restrict this by updating the protection table.
```
p4 protect
```

Update the protection table as shown below, the first line is replaced from
```
write user * * //...
```

to
```
write group admins * //...
```
The above line indicates, only the users who are part of admins group has write permission to all depots in the Perforce server.

The user 'sriram' from any host/machine is given write permission to //myprojects depot.
The user 'jegan' from any host/machine is given write permission to //test-depot depot.

<pre>
Protections:
	write group admins * //...
	list user * * -//spec/...
	super user super * //...
	write user sriram * //myprojects/...
        write user jegan * //test-depot/...
</pre>

In the above protection table, users sriram is given access to myprojects access while user jegan is given access to test-depot project.

Let's verify if sriram can login now, it is supposed to work now.
```
export P4USER=sriram
p4 login
p4 depots
```

Let's verify if sriram can login now, it is supposed to work now.
```
export P4USER=jegan
p4 login
p4 depots
```

## Lab - Create a remote depot

Reference
<pre>
https://www.perforce.com/perforce/doc.072/manuals/p4sag/03_superuser.html
	
https://portal.perforce.com/s/article/2459
</pre>
