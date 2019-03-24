<<<<<<< HEAD
# Project Title

One Paragraph of project description goes here

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests
=======
<img src="https://www.linaro.org/assets/images/projects/yocto-project.png" width="200" align="right">

<br><br>
The ADLINK Yocto x86 64-bit BSP supports all of the following products **

|      **Module Type**                  |       **Module Name**                    |
|:---|:--- |
| <span style="font-size: 8pt;">Com Express Type 6 - Basic Size</span>  | Express-CF/CFE, Express-KL/KLE, Express-SL/SLE      |
| COM Express Type 6 - Compact Size | cExpress-KL, cExpress-SL, cExpress-AL |
| COM Express Type 7               | Express-DN7, Express-DB7 |
| COM Express Type 10            | nanoX-AL   |
| SMARC                            | LEC-AL (under testing) |
| Qseven                           | Q7-AL (under testing) |

**Note:** This BSP provides hardware specific settings, libraries and applications
<br>
<br>
##### This Layer depends on following layers:

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
** Guideline ADLINK [Yocto](https://www.yoctoproject.org/ "Yocto") BSP building**

------------


**1. Set up a build host environment:**

1.1 Recommended Hardware for the host
- Intel Core-i7 Processor (>= 4 cores)
- 8GB Memory
- 500GB Disk sapce
- Ubuntu 18.04 64bit for Yocto Project Build


1.2 Required Packages to install on the host :

	sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat libsdl1.2-dev xterm

**2. Fetch the source from various git location and checkout the specific commit as below:**

2.1 Poky Layer:

	git clone git://git.yoctoproject.org/poky.git poky 
	cd poky
	git checkout fe0fda6d371967f1b28cd8e4d3b3aad997676af0
	cd ..
>>>>>>> a373a79e0d852f76fb22acc3f9e1285613a9bdeb

Explain what these tests test and why

<<<<<<< HEAD
```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.
=======
	git clone git://git.openembedded.org/meta-openembedded
	cd meta-openembedded
	git checkout 8760facba1bceb299b3613b8955621ddaa3d4c3f
	cd ..

2.3 meta-intel Layer:

	git clone git://git.yoctoproject.org/meta-intel -b sumo
	cd meta-intel
	git checkout 90af97d23fb2a56187c2fe2a3f4f4190d7cc2605
	cd ..

2.4 ADLINK Layers:

	git clone http://git.adlinktech.com/yocto/meta-adlink-x86-64bit -b sumo
	git clone http://git.adlinktech.com/sema/meta-adlink-sema

2.5 meta-secure-core Layer:

	git clone https://github.com/jiazhang0/meta-secure-core.git
	cd meta-secure-core
	git checkout 1b35fd45a58ef015b52a3df4b39048f2ac1ffbe3
	cd ..

2.6 meta-virtualization Layer:

	git clone git://git.yoctoproject.org/meta-virtualization -b sumo
	cd meta-virtualization
	git checkout ed2038c935777d1336c17989d454f4e9c95fea7f
	cd ..
>>>>>>> a373a79e0d852f76fb22acc3f9e1285613a9bdeb

## Versioning

<<<<<<< HEAD
We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 
=======
**3. Configure**
>>>>>>> a373a79e0d852f76fb22acc3f9e1285613a9bdeb

## Authors

<<<<<<< HEAD
* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
=======
	source poky/oe-init-build-env

 3.2 Modify the layers as ADLINK confiuration
 
 	cp ../meta-adlink-x86-64bit/conf/Adlink-conf/*.conf conf/

**4. Additional configration**

Please type the following commands if build **Express-DN7**:
>>>>>>> a373a79e0d852f76fb22acc3f9e1285613a9bdeb

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

<<<<<<< HEAD
=======

**5. Start to build the image**

Provide four types of imags and please select one of commands:

|      **image**                        |       **command for the build**                    |     **account/password**  |
|:--- |:--- |:--- |
| minimal image (CLI mode)  | bitbake core-image-minimal     |  root |
| minimal image with SEMA (CLI mode)    | bitbake core-image-mini-sema   |  root|
| support xfce desktop + SEMA          | bitbake core-image-xfce | Not required |
| support xfce desktop + SEMA  + Docker               | 1. enable Docker feature into conf file: <br>`echo "DOCKER_FEATURES = \"enable\"" >> ./conf/local.conf`<br>2. start to build: <br> `bitbake core-image-docker` |   Not required |

**Note**: After finished build progress, you can find images at `${BSP_FOLDER}/build/tmp/deploy/image/inte-corei7-64/`

<br>
**6. To deploy the image you can install the following storage: **
- [USB Drive](#40) 
- [SD Card](#41)
- [eMMC](#43)
- [SATA Drive](#42)


<br>

<h6 id="40">6.1  USB Drive Deployment </h6>

Enter the following command and identify your USB drive :

	lsblk

**Note**: the device name you are searching for and it should looks like /dev/sdb or /dev/sdc

Enter the following command to deploy the image to your USB drive:

	sudo dd if="image name" of="your device name" 
	sync

**Note**: For example, `sudo dd if=adlink-liveimage-x86-intel-corei7-64.hddimg of=/dev/sdb`
<br>
<h6 id="41">6.2 SD Card Deployment</h6>

It requires a bootable yocto USB drive (described above in 5.1) because it includes the grub "install" option.
- prepare the Installation USB drive and insert the USB drive into targe platform
- select the "install" option from grub menu and boot up
- wait until you see the installation target:
"Please select an install target or press n to exit:"
- During installing, system will allocate paritions automatically

**Note**: Please go BIOS menu to configure USB drive as the bootable device

<br>
<h6 id="42">6.3 eMMC Deployment</h6>

It requires a bootable yocto USB drive (described above in 5.1) because it includes the grub "install" option.

- prepare the Installation USB drive and insert the USB drive into targe platform
- select the "install" option from grub menu and boot up
- wait until you see the installation target:
***"Please select an install target or press n to exit:"***
- During installing, system will allocate paritions automatically

**Note**: Please go BIOS menu to configure USB drive as the bootable device

<br>
<h6 id="43">6.3 SATA Deployment</h6>

Please follow the instructions from section "6.2 SD Card Deployment".

<br>




------------



Please feel free to send us (email: ryanzj.huang@adlinktech.com) patches for this layer and report bugs of this layer. 
For hardware support, please contact your local representative.
>>>>>>> a373a79e0d852f76fb22acc3f9e1285613a9bdeb
