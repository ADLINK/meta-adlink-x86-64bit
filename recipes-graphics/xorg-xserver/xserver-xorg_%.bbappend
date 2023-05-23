FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG:append = " xinerama"

PACKAGES:remove = " ${PN}-module-libwfb "
