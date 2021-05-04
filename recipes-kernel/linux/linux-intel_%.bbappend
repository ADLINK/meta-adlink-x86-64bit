FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://regulator.cfg"
SRC_URI += "file://hibernation.cfg"
SRC_URI += "file://drm-avoid-spurious-EBUSY-due-to-nonblocking-atomic-modesets.patch"

