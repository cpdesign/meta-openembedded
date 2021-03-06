DESCRIPTION = "All packages for full XFCE installation"
SECTION = "x11/wm"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r4"

inherit packagegroup

RPROVIDES_${PN} += "task-xfce-extended"
RREPLACES_${PN} += "task-xfce-extended"
RCONFLICTS_${PN} += "task-xfce-extended"

# mandatory
RDEPENDS_${PN} = " \
    packagegroup-xfce-base \
"

# nice to have
RRECOMMENDS_${PN} = " \
    xfwm4-theme-daloa \
    xfwm4-theme-kokodi \
    xfwm4-theme-moheli \
    xfwm4-theme-sassandra \
    xfwm4-theme-stoneage \
    xfwm4-theme-therapy \
    xfwm4-theme-tyrex \
    xfwm4-theme-wallis \
    \
    xfce4-cpufreq-plugin \
    xfce4-cpugraph-plugin \
    xfce4-datetime-plugin \
    xfce4-eyes-plugin \
    xfce4-clipman-plugin \
    xfce4-diskperf-plugin \
    xfce4-netload-plugin \
    xfce4-genmon-plugin \
    xfce4-xkb-plugin \
    xfce4-wavelan-plugin \
    xfce4-places-plugin \
    xfce4-systemload-plugin \
    xfce4-time-out-plugin \
    xfce4-embed-plugin \
    xfce4-weather-plugin \
    \
    xfce4-appfinder \
    xfce4-screenshooter \
    xfce4-power-manager \
    xfce4-mixer \
    ristretto \
"
