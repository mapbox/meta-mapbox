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

SRC_URI[md5sum] = "523edd7fe6b63781c53814433c96c359"
SRC_URI[sha256sum] = "ed0db564efc3fafcaba34bd5df82e1714d60f06aaadf855187040918c6cdc632"

DEPENDS = "variant"

do_compile() {
    true
}

do_install() {
    install -d ${D}/${includedir}/mapbox
    cp -R ${S}/include/mapbox/* ${D}/${includedir}/mapbox
}

PACKAGES = "${PN} ${PN}-dev"
