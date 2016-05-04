SUMMARY = "Minimalist protocol buffer decoder and encoder in C++"
DESCRIPTION = "Designed for high performance. Suitable for writing zero copy parsers and encoders with minimal need for run-time allocation of memory."
HOMEPAGE = "https://github.com/mapbox/protozero"

SECTION = "libs"

S = "${WORKDIR}/protozero-${PV}"

LICENSE = "BSD-2-Clause & Apache-2.0"
LIC_FILES_CHKSUM = "\
    file://LICENSE.md;md5=bb1a27fdd409f635a3f92106ef78d30a \
    file://LICENSE.from_folly;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI = "https://github.com/mapbox/protozero/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "a3e0f71ce53c403802c9887eec146ab0"
SRC_URI[sha256sum] = "85f9238fa662ff06a1e364f1461846a9d377846274e7f98407307e31086cab2b"

do_compile() {
    true
}

do_install() {
    install -d ${D}/${includedir}/protozero
    cp -R ${S}/include/protozero/* ${D}/${includedir}/protozero
}

PACKAGES = "${PN} ${PN}-dev"
