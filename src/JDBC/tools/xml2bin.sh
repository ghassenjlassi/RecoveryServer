#!/bin/sh

TMPFILE=$(basename $1 .xml).tmp
BINFILE=$(basename $1 .xml).bin
MACFILE=$(basename $1 .xml).mac

rm -f $TMPFILE $BINFILE $MACFILE
cat $1 | tr -d '\r' | tr -d '\n' | tr -d '\t' > $TMPFILE
openssl enc -e -in $TMPFILE -out $BINFILE -aes-128-cbc -K 4a6176612052756c65732121203a2d29 -nosalt -iv 00
openssl enc -e -in $BINFILE -out $TMPFILE -aes-128-cbc -K 444d535020666f722065766572202121 -nopad -iv 00
xxd -s -16 -len 8 -p $TMPFILE > $MACFILE
rm -f $TMPFILE
printf "MAC = "
cat $MACFILE
printf "LastUpdate = "
grep " s=" $1 | sed 's/.*s=\"//g;s/\".*//g' | sort -r | head -1
