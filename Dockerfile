FROM ubuntu:latest
LABEL authors="ivannekrylov"

ENTRYPOINT ["top", "-b"]