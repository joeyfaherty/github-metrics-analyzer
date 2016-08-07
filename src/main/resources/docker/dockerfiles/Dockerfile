# TODO: create the jetty image from scratch
FROM jetty:9.3.2
MAINTAINER Joey Faherty "joeyfaherty@live.ie"

# set JETTY_HOME env var
ENV JETTY_HOME /usr/local/jetty
# add the war file to the container
ADD ./target/*.war $JETTY_HOME/webapps/github-metrics.war
# sets the working directory for any RUN, CMD etc commands that follow
WORKDIR $JETTY_HOME
# CMD instruction sets the command to be executed when running the image
CMD ["java", "-jar", "start.jar"]