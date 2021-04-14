#!/bin/sh -e

PWD=$(pwd)

usage ()
{
  echo -e "Usage: . $0 [build directory]"
}

if [ -x "$PWD/poky/oe-init-build-env" ]; then
  PROGNAME="$PWD/poky/oe-init-build-env"
else
  usage
  return 1
fi

if [ $? != 0 -o $# -lt 1 ]; then
  usage
  return 1
fi

while test -n "$1"; do
  case "$1" in
    "--help" | "-h")
      usage
      return 0
      ;;
    *)
      BUILDDIR=$1
    ;;
  esac
  shift
done

THIS_SCRIPT="adlink-intel-setup-release.sh"
if [ "$(basename -- $0)" = "$THIS_SCRIPT" ]; then
    echo "Error: This script needs to be sourced. Please run as '. $0'"
    return 1
fi

# Set up the basic yocto environment by sourcing fsl community's setup-environment bash script with/without TEMPLATECONF
if [ -z "$TEMPLATECONF" ]; then
  # gets the conf
  if [ -z "$CONF" ]; then
    echo "Error: CONF variable not defined, please define CONF=adlink/mainline for TEMPLATECONF."
    return 1
  else
    if [ ! -d $PWD/meta-adlink-x86-64bit/conf/$CONF-conf ]; then
      echo "Error: $PWD/meta-adlink-x86-64bit/conf/$CONF-conf directory not found."
      return 1
    fi
    echo "Setup yocto environment for building adlink x86_64 target board."
    echo "    TEMPLATECONF=$PWD/meta-adlink-x86-64bit/conf/$CONF-conf source $PROGNAME $BUILDDIR"
    echo ""
    TEMPLATECONF="$PWD/meta-adlink-x86-64bit/conf/$CONF-conf" source $PROGNAME $BUILDDIR
  fi
else
  source $PROGNAME $BUILDDIR
fi

unset PWD
unset PROGNAME
unset THIS_SCRIPT
unset TEMPLATECONF
unset BUILDDIR

