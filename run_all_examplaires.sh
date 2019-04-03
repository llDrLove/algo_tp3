#!/bin/bash
for test in $(ls ./exemplaires)
do
	./tp.sh -e ./exemplaires/$test >> ./results/"$test"_results
done