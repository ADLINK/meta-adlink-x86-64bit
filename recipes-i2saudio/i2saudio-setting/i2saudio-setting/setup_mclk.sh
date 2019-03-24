#!/bin/bash
nhlt_dir=$(find /sys/kernel/debug/ -name "nhlt")
echo 'writing ssp blob configuration into below path'
echo $nhlt_dir
echo 'enable' | tee $nhlt_dir/control
cat 2ch_48k_32b_in_32b_i2s1mclk_socmaster.blob | tee $nhlt_dir/ssp0p > /dev/null
cat 2ch_48k_32b_in_32b_i2s1mclk_socmaster.blob | tee $nhlt_dir/ssp0c > /dev/null

cat 2ch_48k_32b_in_32b_i2s1mclk_socmaster.blob | tee $nhlt_dir/ssp1p > /dev/null
cat 2ch_48k_32b_in_32b_i2s1mclk_socmaster.blob | tee $nhlt_dir/ssp1c > /dev/null

cat 2ch_48k_32b_in_32b_i2s1mclk_socmaster.blob | tee $nhlt_dir/ssp3p > /dev/null
cat 2ch_48k_32b_in_32b_i2s1mclk_socmaster.blob | tee $nhlt_dir/ssp3c > /dev/null



