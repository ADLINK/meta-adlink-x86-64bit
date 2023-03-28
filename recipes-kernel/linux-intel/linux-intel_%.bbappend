FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = "  file://adlink-x68-kmeta;type=kmeta;destsuffix=/adlink-x68-kmeta \
"		    
KERNEL_FEATURES:append:x86-64 = "adlink.scc"

SRCREV_machine = "${AUTOREV}"
	    
