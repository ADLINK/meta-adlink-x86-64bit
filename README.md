<img src="https://www.linaro.org/assets/images/projects/yocto-project.png" width="200" align="right">

<br>


### Yocto ISO Images for the quick evaluation

* xfce Desktop environment + [SEMA 4.0](https://adlink-epm.github.io/sema-doc/#/) (image size: 2.5 GB) [download link](https://hq0epm0west0us0storage.blob.core.windows.net/public/COM%20X86/Images/Yocto/adlink-xfce-x86-intel-corei7-64-20200506054002.iso)
* minimal image with commandine mode + [SEMA 4.0](https://adlink-epm.github.io/sema-doc/#/) (image size: 1.3 GB) [download link](https://hq0epm0west0us0storage.blob.core.windows.net/public/COM%20X86/Images/Yocto/adlink-mini-x86-intel-corei7-64-20200507014241.iso)


<br>

### Zeus Branch details


|     **meta name**        |             **version**                    |  **commit version**  |
|:---|:--- |:--- |
|  poky   |  zeus  | 94f6b31befda5c496f65e863a6f8152b42d7ebf0 |
|meta-openembedded|zeus|bb65c27a772723dfe2c15b5e1b27bcc1a1ed884c|
|meta-intel| zeus |faced19dda5332cce9164903b250db5aa9b86259|
|meta-adlink-x86-64bit| zeus   |3612240947d3f368aedcd003796e9cbb334b794b |
|meta-adlink-sema| master | d2f7ed215b0e3773f4e51a89b64a5f2233a65f32 |
|meta-qt5| zeus |0bdbb344bc0a7261d76d715e570ddc2ecfefae58|
|meta-secure-core| master |e8e80fb7c4971bb05e14ec5e329c1435ba485b2b|
|meta-python2| zeus |4400f9155ec193d028208cf0c66aeed2ba2b00ab|

<br> 

### How to build Yocto Image
* see [the documentation](https://github.com/ADLINK/meta-adlink-x86-64bit/wiki/01.-Build-Yocto-Image) for the more details
 
<br>


### how to flash ISO image to your storage
* [Boot from USB drive](https://github.com/ADLINK/meta-adlink-x86-64bit/wiki/02.-How-to-install-Yocto-Image-to-USB-Drive)
* [Boot from eMMC/SD Card](https://github.com/ADLINK/meta-adlink-x86-64bit/wiki/03.-How-to-install-Yocto-Image-to-eMMC-&-SD-Card)
* [Boot from SATA drive](https://github.com/ADLINK/meta-adlink-x86-64bit/wiki/04.-How-to-install-Yocto-Image-to-SATA-Drive)

<br> 

### Supported Hardware List
* see [the list](https://github.com/ADLINK/meta-adlink-x86-64bit/tree/master#the-following-products-are-supported-) for more details

<br>


Please feel free to send us (email: ryanzj.huang@adlinktech.com) patches for this layer and report bugs of this layer. 
<br>For hardware support, please contact your local representative.
