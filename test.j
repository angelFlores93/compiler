.class public simple
.super java/lang/Object
.method public <init>()V
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method

;Line: 2
;Variable n: (direccion 0)
;Line: 2
;Variable i: (direccion 1)
;Line: 3
;Variable c: (direccion 2)
.method public static main([Ljava/lang/String;)V
.limit stack 5
.limit locals 100

;Line 7
sipush 10
istore 0
;Line: 8
iload 0
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(I)V
return
.end method