SUMMARY = "Slice GeoJSON into vector tiles on the fly in the browser"
DESCRIPTIOn = "Port to C++ of JS GeoJSON-VT for slicing GeoJSON into vector tiles on the fly."
HOMEPAGE = "https://github.com/mapbox/geojson-vt-cpp"

LICENSE ="BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8939f505214a419291c820c4aa8275bd"

SECTION = "libs"

S = "${WORKDIR}/geojson-vt-cpp-${PV}"

SRC_URI = "https://github.com/mapbox/geojson-vt-cpp/archive/v${PV}.tar.gz"

SRC_URI[md5sum] = "eb23777877c1d1920cae282db539824b"
SRC_URI[sha256sum] = "38cc630cacf58cad3e21df8a1c8fd711c8f70868c1ffbe7b8c9df87c796f9727"

DEPENDS = "rapidjson variant"

EXTRA_OEMAKE = "CXXFLAGS=-fPIC"

GYP_FLAGS = "\
    -Dinstall_prefix=${D}/${prefix} \
    -Drapidjson_cflags=""\
    -Dvariant_cflags="" \
    -Dgtest=0 \
    -Dglfw=0"

do_configure() {
    deps/run_gyp geojsonvt.gyp --depth=${S} -Goutput_dir=${S} --generator-output=${S}/build ${GYP_FLAGS}
}

do_compile() {
    oe_runmake -C${S}/build
}

do_install() {
    oe_runmake -C${S}/build install
}

PACKAGES = "${PN} ${PN}-dev ${PN}-staticdev"
