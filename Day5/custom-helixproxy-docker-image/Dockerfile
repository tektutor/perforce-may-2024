FROM ubuntu:20.04
MAINTAINER Jeganathan Swaminathan <jegan@tektutor.org>

RUN apt update && apt install -y wget curl gpg

COPY runme.sh .

RUN ./runme.sh

COPY perforce.list /etc/apt/sources.list.d/perforce.list

RUN apt update && apt-get install helix-proxy -y

RUN mkdir -p /var/proxyroot

CMD [ "p4p", "-p tcp64:[::]:1999", "-t 172.20.10.5:1666", "-r /var/proxyroot"]
