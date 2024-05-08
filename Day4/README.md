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
p4 files @v1.0
```

Expected output
<pre>
p4 files @v1.0
//myprojects/rel-1.0/spring-ms/pom.xml#3 - edit change 16 (text)
//myprojects/rel-1.0/spring-ms/src/main/java/com/example/springboot/Application.java#1 - branch change 14 (text)
//myprojects/rel-1.0/spring-ms/src/main/java/com/example/springboot/HelloController.java#1 - branch change 14 (text)  
</pre>
