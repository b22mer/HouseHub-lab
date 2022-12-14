FROM node:16-alpine AS builder
WORKDIR /app
# package json copy
COPY package*.json ./
COPY yarn.lock ./
RUN yarn
COPY . .
RUN yarn build
EXPOSE 8080
CMD ["yarn", "serve"]