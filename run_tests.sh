#!/bin/bash

for ((i=1;i<=3;i++));
do
  command_line_options=$(cat "tests/command_line_options/command_line_option$i.txt")
  expected_out=$(cat "tests/outputs/output$i.txt")

  cp "tests/inputs/input$i.txt" input.txt
  actual_out=$(java -jar ./build/libs/basic_programming_2020-1.jar $command_line_options)
  rm input.txt

  if [ "$actual_out" != "$expected_out" ]
    then
      echo "ERROR in test $i"
      echo $actual_out
      exit 1
  fi
done