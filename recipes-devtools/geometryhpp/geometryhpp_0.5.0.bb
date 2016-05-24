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

SRC_URI[md5sum] = "724dada9cdc96fef1346024da3c1d70a"
SRC_URI[sha256sum] = "30c566ab79d1703433d2af7a6b5cbdb7f5cffe36679a0e0f847ad99d4f9ae798"

DEPENDS = "variant"

do_compile() {
    true
}

do_install() {
    install -d ${D}/${includedir}/mapbox
    cp -R ${S}/include/mapbox/* ${D}/${includedir}/mapbox
}

PACKAGES = "${PN} ${PN}-dev"
