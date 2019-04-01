<img src="https://www.linaro.org/assets/images/projects/yocto-project.png" width="200" align="right">

<br>
<br>
<br>

Yocto x86 64-bit BSP supports all of the following products:
-----

|      **Module Type**                  |       **Module Name**                    |
|:---|:--- |
|Com Express Type 6 - Basic Size | Express-CF/CFE, Express-KL/KLE, Express-SL/SLE      |
| COM Express Type 6 - Compact Size | cExpress-KL, cExpress-SL, cExpress-AL |
| COM Express Type 7               | Express-DN7, Express-DB7 |
| COM Express Type 10            | nanoX-AL   |
| SMARC                            | LEC-AL (under testing) |
| Qseven                           | Q7-AL (under testing) |

&nbsp;&nbsp; **Note:** This BSP provides hardware specific settings, libraries and applications
<br>
<br>
 
This Layer depends on following layers:
----

|     **meta name**        |             **version**                    |  **commit version**  |
|:---|:--- |:--- |
|  poky   |  Origin/sumo-next     |  fe0fda6d371967f1b28cd8e4d3b3aad997676af0   |
|meta-openembedded|Origin/sumo|8760facba1bceb299b3613b8955621ddaa3d4c3f|
|meta-intel| Orgin/sumo|90af97d23fb2a56187c2fe2a3f4f4190d7cc2605|
|meta-adlink-x86-64bit|  Origin/sumo| | 
|meta-adlink-sema| Origin/master||
|meta-secure-core|Origin/sumo|1b35fd45a58ef015b52a3df4b39048f2ac1ffbe3|
|meta-virtualization|Origin/sumo |ed2038c935777d1336c17989d454f4e9c95fea7f|


<br> 

Guideline ADLINK [Yocto](https://www.yoctoproject.org) BSP building:
----

**1. Set up a build host environment:**

&nbsp;&nbsp;1.1 Recommended Hardware for the host
- Intel Core-i7 Processor (>= 4 cores)
- 8GB Memory
- 500GB Disk sapce
- Ubuntu 18.04 64bit for Yocto Project Build


&nbsp;&nbsp;1.2 Required Packages to install on the host :

	sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib 
	sudo apt-get install build-essential chrpath socat libsdl1.2-dev xterm

**2. Fetch the source from various git location and checkout the specific commit as below:**

&nbsp;&nbsp;2.1 Poky Layer:

	git clone git://git.yoctoproject.org/poky.git -b sumo
	cd poky
	git checkout fe0fda6d371967f1b28cd8e4d3b3aad997676af0
	cd ..

&nbsp;&nbsp;2.2 meta-openmbedded Layer:

	git clone git://git.openembedded.org/meta-openembedded
	cd meta-openembedded
	git checkout 8760facba1bceb299b3613b8955621ddaa3d4c3f
	cd ..

&nbsp;&nbsp;2.3 meta-intel Layer:

	git clone git://git.yoctoproject.org/meta-intel -b sumo
	cd meta-intel
	git checkout 90af97d23fb2a56187c2fe2a3f4f4190d7cc2605
	cd ..

&nbsp;&nbsp;2.4 ADLINK Layers:

	git clone http://github.com/adlink/meta-adlink-x86-64bit -b sumo
	git clone http://github.com/adlink/meta-adlink-sema

&nbsp;&nbsp;2.5 meta-secure-core Layer:

	git clone https://github.com/jiazhang0/meta-secure-core.git
	cd meta-secure-core
	git checkout 1b35fd45a58ef015b52a3df4b39048f2ac1ffbe3
	cd ..

&nbsp;&nbsp;2.6 meta-virtualization Layer:

	git clone git://git.yoctoproject.org/meta-virtualization -b sumo
	cd meta-virtualization
	git checkout ed2038c935777d1336c17989d454f4e9c95fea7f
	cd ..


**3. Configure**

 &nbsp;&nbsp;3.1  Set up the build environment variables and build directory 

	source poky/oe-init-build-env

 &nbsp;&nbsp;3.2 Modify the layers as ADLINK confiuration
 
 	cp ../meta-adlink-x86-64bit/conf/Adlink-conf/*.conf conf/

**4. Additional configration**

&nbsp;&nbsp;Please type the following commands if build **Express-DN7**:

    cat >>./conf/local.conf <<-'EOF'
	# Additional Kernel Features to enable QAT, DPDK and QEMU-KVM
	KERNEL_FEATURES_append = " features/qat/qat.scc"
	KERNEL_FEATURES_append = " features/x2apic/x2apic.scc"
	KERNEL_FEATURES_append = " features/vfio/vfio.scc"
	KERNEL_FEATURES_append = " features/numa/numa.scc"
	KERNEL_FEATURES_append = " features/mtd/mtd.scc"
	KERNEL_FEATURES_append = " features/iommu/iommu.scc"
	KERNEL_FEATURES_append = " features/intel-txt/intel-txt.scc"
	KERNEL_FEATURES_append = " features/kvm/qemu-kvm-enable.scc"

	# OOT IXGBE & IXGBEVF kernel
	IMAGE_INSTALL_append = " ixgbe"
	IMAGE_INSTALL_append = " ixgbevf"
	EOF


**5. Start to build the image**

&nbsp;&nbsp;Provide four types of imags and please select one of commands:

|      **image**                        |       **command for the build**   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|     **account/pwd**  |
|:--- |:--- |:--- |
| minimal image (CLI mode)| bitbake core-image-minimal     |  root |
| minimal image with SEMA (CLI mode)| bitbake core-image-mini-sema   |  root|
| Image with <br>&nbsp;- xfce desktop <br>&nbsp;- SEMA| bitbake core-image-xfce | Not required |
| Image with <br>&nbsp;- xfce desktop <br>&nbsp;- SEMA<br>&nbsp;- Docker| 1. enable Docker feature into conf file: <br>`echo "DOCKER_FEATURES = \"enable\"" >> ./conf/local.conf`<br>2. start to build: <br> `bitbake core-image-docker` |   Not required |

&nbsp;&nbsp;**Note**: After finished build progress, you can find images at `${BSP_FOLDER}/build/tmp/deploy/image/inte-corei7-64/`

<br>

**6. To deploy the image you can install the following storage**

- [USB Drive](#40) 
- [SD Card](#41)
- [eMMC](#43)
- [SATA Drive](#42)

&nbsp;&nbsp;<h5 id="40">6.1  USB Drive Deployment </h5>

&nbsp;&nbsp;Enter the following command and identify your USB drive :

	lsblk

&nbsp;&nbsp;**Note**: the device name you are searching for and it should looks like /dev/sdb or /dev/sdc

&nbsp;&nbsp;Enter the following command to deploy the image to your USB drive:

	sudo dd if="image name" of="your device name" 
	sync

&nbsp;&nbsp;**Note**: For example, `sudo dd if=adlink-liveimage-x86-intel-corei7-64.hddimg of=/dev/sdb`


&nbsp;&nbsp;<h5 id="41">6.2 SD Card Deployment</h5>

&nbsp;&nbsp;It requires a bootable yocto USB drive (described above in 5.1) because it includes the grub "install" option.
- prepare the Installation USB drive and insert the USB drive into targe platform
- select the "install" option from grub menu and boot up
- wait until you see the installation target:&nbsp;**"Please select an install target or press n to exit:"**
- During installing, system will allocate paritions automatically

&nbsp;&nbsp;**Note**: Please go BIOS menu to configure USB drive as the bootable device


&nbsp;&nbsp;<h5 id="43">6.3 eMMC Deployment</h5>

&nbsp;&nbsp;It requires a bootable yocto USB drive (described above in 5.1) because it includes the grub "install" option.

- prepare the Installation USB drive and insert the USB drive into targe platform
- select the "install" option from grub menu and boot up
- wait until you see the installation target:&nbsp;&nbsp;**"Please select an install target or press n to exit:"**
- During installing, system will allocate paritions automatically

&nbsp;&nbsp;**Note**: Please go BIOS menu to configure USB drive as the bootable device


&nbsp;&nbsp;<h5 id="42">6.3 SATA Deployment</h5>

&nbsp;&nbsp;Please follow the instructions from section "6.2 SD Card Deployment".

<br>




----



Please feel free to send us (email: ryanzj.huang@adlinktech.com) patches for this layer and report bugs of this layer. 
<br>For hardware support, please contact your local representative.
