SUMMARY = "C++ geometry types"
DESCRIPTION = "Provides header-only, generic C++ interfaces for geometry types, geometry collections, and features."
HOMEPAGE = "https://github.com/mapbox/geometry.hpp"

SECTION = "libs"

S = "${WORKDIR}/geometry.hpp-${PV}"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6e44f5d6aeec54f40fc84eebe3c6fc6c"

SRC_URI = "\
    https://github.com/mapbox/geometry.hpp/archive/v${PV}.tar.gz \
    file://01-gcc4_compat.patch"

SRC_URI[md5sum] = "88cb99e9ddebbdc3c5d1f20fe44a6887"
SRC_URI[sha256sum] = "e095fd3af43caba8fd453c152c6b751f2a05f2ddccc41cbc01e3ab0cf959ce48"

DEPENDS = "variant"

do_compile() {
    true
}

do_install() {
    install -d ${D}/${includedir}/mapbox
    cp -R ${S}/include/mapbox/* ${D}/${includedir}/mapbox
}

PACKAGES = "${PN} ${PN}-dev"
