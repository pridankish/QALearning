FROM jenkins/jenkins:lts-jdk17

USER root

# Установка Gradle
RUN apt-get update && \
    apt-get install -y curl unzip && \
    curl -s "https://get.sdkman.io" | bash && \
    bash -c "source /root/.sdkman/bin/sdkman-init.sh && sdk install gradle 8.5"

# Возвращаемся к пользователю jenkins
USER jenkins

# Установка рекомендуемых плагинов
RUN jenkins-plugin-cli --plugins \
    gradle:3.2.0 \
    workflow-aggregator:2.6 \
    git:5.0.0