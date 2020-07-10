<img src="https://www.linaro.org/assets/images/projects/yocto-project.png" width="200" align="right">

<br>


## Dowload a Live OS image for quick evaluation:

<strong>1. There are four OS images (ISO format) Without "Express-DN7 module":</strong>
<ul>
<li>minimal image (CLI mode)&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://drive.google.com/file/d/1bh_AH7W4no2DJvavmWP9UDxaJ0GBnn0Y/view?usp=sharing" target="_blank" rel="noopener"><img src="https://cdn3.iconfinder.com/data/icons/wireless/512/4-512.png" width="25" /></a></li>
<li>minimal image with SEMA (CLI mode)&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://drive.google.com/file/d/13pJtZcn5QBy_lJGVyP1Ws4dy491MzQy8/view?usp=sharing"><img src="https://cdn3.iconfinder.com/data/icons/wireless/512/4-512.png" width="25" /></a></li>
<li>Image with "xfce desktop" &amp; "SEMA"&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://drive.google.com/file/d/1nyHvEHqcukYTOrTP8mqAfhH58g5da7KZ/view?usp=sharing" target="_blank" rel="noopener"><img src="https://cdn3.iconfinder.com/data/icons/wireless/512/4-512.png" width="25" /></a></li>
<li>Image with "xfce desktop" &amp; "SEMA" &amp; "Docker"&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://drive.google.com/file/d/1OjPXihQwvbFlo1lTfrk_rnTdCM8w4e03/view?usp=sharing" target="_blank" rel="noopener"><img src="https://cdn3.iconfinder.com/data/icons/wireless/512/4-512.png" width="25" /></a></li>
</ul>

<br>

<p><strong>2. There are four OS images (ISO format) for "Express-DN7 module":</strong></p>
<ul>
<li>minimal image (CLI mode)&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://drive.google.com/file/d/12FSF986aWkyA-erbeLPN2rBrBvG04IwN/view?usp=sharing" target="_blank" rel="noopener"><img src="https://cdn3.iconfinder.com/data/icons/wireless/512/4-512.png" width="25" /></a></li>
<li>minimal image with SEMA (CLI mode)&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://drive.google.com/file/d/1IzHyTgRflFPKJ57M-mxg-SqDimm1L8ZB/view?usp=sharing" target="_blank" rel="noopener"><img src="https://cdn3.iconfinder.com/data/icons/wireless/512/4-512.png" width="25" /></a></li>
<li>Image with "xfce desktop" &amp; "SEMA"&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://drive.google.com/file/d/1DsYr-IKJ-2kI2pkdzcKWNF4dmzpL4drU/view?usp=sharing" target="_blank" rel="noopener"><img src="https://cdn3.iconfinder.com/data/icons/wireless/512/4-512.png" width="25" /></a></li>
<li>Image with "xfce desktop" &amp; "SEMA" &amp; "Docker"&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://drive.google.com/file/d/1a2-zskbrfFPU7S7jGzauImAyQ3gxDTxP/view?usp=sharing" target="_blank" rel="noopener"><img src="https://cdn3.iconfinder.com/data/icons/wireless/512/4-512.png" width="25" /></a></li>
</ul>

<br>&nbsp;&nbsp;&nbsp;&nbsp; **Note:** please refer to <a href="https://github.com/ADLINK/meta-adlink-x86-64bit/wiki/02.-How-to-install-Yocto-Image-to-USB-Drive" width="25" />the gudieline to bootup from USB drive</a>

<br>
 
This Layer depends on following layers
----

|     **meta name**        |             **version**                    |  **commit version**  |
|:---|:--- |:--- |
|  poky   |  Origin/sumo     |  5ddf7fff992b065ee512878d2fe65f3e35d818cf   |
|meta-openembedded|Origin/sumo|8760facba1bceb299b3613b8955621ddaa3d4c3f|
|meta-intel| Orgin/sumo|90af97d23fb2a56187c2fe2a3f4f4190d7cc2605|
|meta-adlink-x86-64bit|  Origin/sumo| | 
|meta-adlink-sema| Origin/master||
|meta-qt5| Origin/sumo|d4e7f73d04e8448d326b6f89908701e304e37d65|
|meta-secure-core|Origin/sumo|1b35fd45a58ef015b52a3df4b39048f2ac1ffbe3|
|meta-virtualization|Origin/sumo |ed2038c935777d1336c17989d454f4e9c95fea7f|

<br>

 
Please refer to [Guideline](https://github.com/ADLINK/meta-adlink-x86-64bit/wiki) for Yocto BSP building
----

<br>



Please feel free to send us (email: ryanzj.huang@adlinktech.com) patches for this layer and report bugs of this layer. 
<br>For hardware support, please contact your local representative.
