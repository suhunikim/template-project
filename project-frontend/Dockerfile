# project-frontend/Dockerfile

# --- Build Stage ---
# Node.js 18 슬림 버전 이미지를 기반으로 빌드 스테이지 시작 (필요에 따라 버전 변경)
FROM node:18-slim AS build

# 컨테이너 내 작업 디렉토리 설정
WORKDIR /app

# package.json과 package-lock.json (또는 yarn.lock) 파일을 먼저 복사
# -> 의존성 설치 캐싱을 활용하여 빌드 속도 향상
COPY package*.json ./

# 의존성 설치
RUN npm install

# 나머지 소스 코드 복사
COPY . .

# React 애플리케이션 빌드 (npm run build)
RUN npm run build

# --- Runtime Stage ---
# Nginx 알파인 버전 이미지를 기반으로 런타임 스테이지 시작
FROM nginx:alpine

# 빌드 스테이지에서 생성된 빌드 결과물(/app/dist)을
# Nginx의 기본 웹 루트 디렉토리(/usr/share/nginx/html)로 복사
COPY --from=build /app/dist /usr/share/nginx/html

# (선택 사항) Nginx 설정 파일 복사 (커스텀 설정이 필요한 경우)
# COPY nginx.conf /etc/nginx/conf.d/default.conf

# 컨테이너가 노출할 포트 지정 (Nginx는 기본적으로 80 포트 사용)
EXPOSE 80