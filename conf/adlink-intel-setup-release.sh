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

# Set up the basic yocto environment by sourcing setup-environment bash script adlink or mainline config
if [ -z "$CONF" ]; then
  echo "Error: CONF variable not defined, please define CONF=adlink or mainline for appending adlink or mainline specific settings."
  return 1
else
  if [ ! -d $PWD/meta-adlink-x86-64bit/conf/$CONF-conf ]; then
    echo "Error: $PWD/meta-adlink-x86-64bit/conf/$CONF-conf directory not found."
    return 1
  fi
fi

source $PROGNAME $BUILDDIR

# append additional settings according to $CONF
if [ -f $PWD/../meta-adlink-x86-64bit/conf/$CONF-conf/bblayers.conf.append -a -f conf/bblayers.conf ]; then
  cat $PWD/../meta-adlink-x86-64bit/conf/$CONF-conf/bblayers.conf.append >> conf/bblayers.conf
fi
if [ -f $PWD/../meta-adlink-x86-64bit/conf/$CONF-conf/local.conf.append -a -f conf/local.conf ]; then
  cat $PWD/../meta-adlink-x86-64bit/conf/$CONF-conf/local.conf.append >> conf/local.conf
fi

unset PWD
unset PROGNAME
unset THIS_SCRIPT
unset TEMPLATECONF
unset BUILDDIR

