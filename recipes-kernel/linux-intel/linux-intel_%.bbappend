FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = "  file://adlink-x68-kmeta;type=kmeta;destsuffix=/adlink-x68-kmeta \
		     file://0001-Avoid-ACPI-probe-due-to-resource-conflict-with-BIOS.patch"		    
