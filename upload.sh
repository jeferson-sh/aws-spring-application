#!/bin/sh

# Define o bucket S3 e o caminho para o upload
S3_BUCKET=bucket-s3-terraform
DUMP_PATH=/tmp

# Nome do serviço
SERVICE_NAME=${SERVICE_NAME:-application}

# Obtém o timestamp atual
TIMESTAMP=$(date +%Y%m%d%H%M%S)

# Procura pelo arquivo de heap dump
DUMP_FILE=$(ls -t $DUMP_PATH/java_pid*.hprof | head -n 1)

if [ -n "$DUMP_FILE" ]; then
  # Novo nome do arquivo com o nome do serviço e timestamp
  NEW_DUMP_FILE="$DUMP_PATH/${SERVICE_NAME}_heapdump_${TIMESTAMP}.hprof"

  # Renomeia o arquivo
  mv "$DUMP_FILE" "$NEW_DUMP_FILE"

  echo "Uploading $NEW_DUMP_FILE to s3://$S3_BUCKET/"
  aws s3 cp "$NEW_DUMP_FILE" s3://$S3_BUCKET/
else
  echo "No heap dump file found."
fi