.class public compiler
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
;Variable z: (direccion 2)
.method public static sum()I
.limit locals 10
.limit stack 10
;Line 6
ldc 3
istore 6
;Line 7
ldc 5
istore 5
;Line 8
;Line: 8
iload 6
iload 5
iadd
istore 4
;Line: 9
iload 4
ireturn
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 5
.limit locals 100

;Line: 13
invokestatic compiler.sum()I
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(I)V
return
.end method