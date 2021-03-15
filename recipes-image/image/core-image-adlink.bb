DESCRIPTION = "ADLINK BSP Image with XFCE X Window"

LICENSE = "MIT"

#IMAGE_FEATURES += " package-management ssh-server-dropbear hwcodecs"
IMAGE_FEATURES += "package-management"

inherit core-image


## X-Server
REQUIRED_DISTRO_FEATURES = "x11"
IMAGE_FEATURES += "x11-base"
IMAGE_INSTALL_append = " packagegroup-core-x11 xserver-xorg xterm xinit-env startupconfig"

### XFCE desktop
IMAGE_INSTALL_append = " packagegroup-xfce-base garcon sysprof xfce4-screenshooter ristretto xfce4-taskmanager xfce4-appfinder xfce-dusk-gtk3 thunar-volman"

### XFCE Tools
IMAGE_INSTALL_append = " garcon sysprof xfce4-screenshooter ristretto xfce4-taskmanager xfce4-appfinder xfce-dusk-gtk3 thunar-volman"

## Remove icewm
IMAGE_INSTALL_remove = "icewm"

## SEMA applications
IMAGE_INSTALL_append = " sema4.0"

## For additional tools/packages
IMAGE_INSTALL_append = " libstdc++ kernel-modules kernel-devsrc packagegroup-base alsa-utils packagegroup-core-full-cmdline"
IMAGE_INSTALL_append = " i2c-tools usbotg-setting i2saudio-setting lsb-release camera-setting dmidecode lshw"
IMAGE_INSTALL_append = " mcelog evince haveged ntp ntpdate qtbase"
IMAGE_INSTALL_append = " git curl wget which busybox bzip2 cmake bash tar gzip kmod ethtool ifupdown inetutils init-ifupdown iw minicom net-tools vim openssh"

## Tools
IMAGE_INSTALL_append = " git wget which busybox bzip2 cmake bash tar gzip kmod ethtool i2c-tools ifupdown inetutils init-ifupdown iw minicom net-tools vim openssh "

## For additional tools/packages
IMAGE_INSTALL_append = " mcelog lshw ntp ntpdate libstdc++ kernel-modules kernel-devsrc dmidecode qtbase"

## For UART port test
IMAGE_INSTALL_append = " python3-pyserial"

## For multimedia
IMAGE_INSTALL_append = " gstreamer1.0-plugins-ugly gstreamer1.0-libav"

## TPM_1.x & TPM_2.0 tool
#PREFERRED_VERSION_tpm2-tss = "1.4.0"
#IMAGE_INSTALL_append = " packagegroup-security-tpm"
## TPM_2.0 tool
#IMAGE_INSTALL_append = " tpm2-tools libtss2 tpm2-abrmd tpm2-tss"

IMAGE_INSTALL_append = " packagegroup-security-tpm2"

## TPM_1.x tool
#IMAGE_INSTALL_append = " tpm-tools trousers"

## Linux ptp
IMAGE_INSTALL_append = " linuxptp"

## NFS supported
IMAGE_INSTALL_append = " rpcbind nfs-utils-mount nfs-utils-client nfs-utils"

## CIFS supported
IMAGE_INSTALL_append = " cifs-utils"

## Add terminus-font
#IMAGE_INSTALL_append = " terminus-font"

## For time zone setting
IMAGE_INSTALL_append = " tzdata"

## For IBECC test
IMAGE_INSTALL_append = " devmem2"

## Add network manager, this will conflict with connman
#IMAGE_INSTALL_append = " networkmanager"

## Remove mender
INHERIT_remove = "mender-full"

APPEND += "video=eDP-1:d"
