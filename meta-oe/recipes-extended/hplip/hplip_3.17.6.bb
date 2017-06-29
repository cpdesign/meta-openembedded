DESCRIPTION = "HP Linux Imaging and Printing"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=cc45ea9f437f3364019bed3ef8270b63"

SRC_URI = "https://downloads.sourceforge.net/project/hplip/hplip/3.17.6/hplip-3.17.6.tar.gz \
           file://fix-libusb-paths.patch \
	  "

DEPENDS += "cups python libusb"

inherit autotools python-dir pythonnative

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

EXTRA_OECONF += "\
        LIBUSBINCLUDEROOT=${STAGING_INCDIR} \
        --disable-network-build \
        --disable-doc-build \
        --disable-pp-build \
        --disable-scan-build \
        --disable-gui-build \
        --disable-fax-build \
        --disable-policykit  \
        --disable-qt4 \
        --disable-qt3 \
        --disable-dbus-build \
        --disable-foomatic-drv-install \
        --enable-foomatic-ppd-install  \
        --enable-foomatic-rip-hplip-install \
        "

PACKAGES += "${PN}-ppd ${PN}-cups ${PN}-backend ${PN}-filter ${PN}-hal"

RDEPENDS_${PN} += " \
        python-syslog \
        python-pprint \
        python-compression \
        python-shell \
        python-xml \
        python-unixadmin \
        python-html \
        python-resource \
        python-terminal \
        python-subprocess\
        "

# need to snag the debug file or OE will fail on backend package
FILES_${PN}-dbg += "\
        ${libdir}/cups/backend/.debug \
        ${PYTHON_SITEPACKAGES_DIR}/.debug \
        ${libdir}/cups/filter/.debug "

FILES_${PN}-dev += "${PYTHON_SITEPACKAGES_DIR}/*.la"
FILES_${PN}-ppd = "${datadir}/ppd"
FILES_${PN}-cups = "${datadir}/cups"
FILES_${PN}-backend = "${libdir}/cups/backend"
FILES_${PN}-filter = "${libdir}/cups/filter"
FILES_${PN}-hal = "${datadir}/hal"

FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}/*.so"

SRC_URI[md5sum] = "12aea2af77b4c609ba524c3203e5a6df"
SRC_URI[sha256sum] = "80287834aad7e3fa30f2e252ff281d351e3f2eb15267ac541531353dc7b5107e"

