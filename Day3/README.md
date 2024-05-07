# Day 3

## Lab - Print a depot file revisions also prints content changes done
```
p4 depots
p4 print  -a //myprojects/...
```

## Lab - Print revisions of a specific file in a depot also prints content changes done
```
p4 print  -a //myprojects/main/fruits.txt
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
p4 user -f jegan
```
