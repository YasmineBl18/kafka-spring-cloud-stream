<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Test Kafka - Producer & Consumer</title>
</head>
<body>

<h1>Kafka – Producer & Consumer</h1>


<p>Ce guide explique comment tester rapidement Kafka avec :</p>
<ul>
    <li><strong>kafka-console-producer</strong> (producteur)</li>
    <li><strong>kafka-console-consumer</strong> (consommateur)</li>
</ul>

<hr>

<h2> 1. Vérifier que Kafka tourne (Docker)</h2>

<pre>
<code>docker ps</code>
</pre>

<p>Le conteneur Kafka (ex : <em>bdcc-kafka-broker</em>) doit apparaître.</p>

<hr>



<hr>

<h2>✉️ 3. Envoyer des messages (Producer)</h2>

<pre>
<code>
docker exec -it bdcc-kafka-broker kafka-console-producer \
  --broker-list broker:9092 \
  --topic R2
</code>
</pre>

<p>Écrire ensuite :</p>

<pre>
<code>
Hello Kafka
Message 1
Message 2
</code>
</pre>

<hr>

<h2> 4. Lire les messages (Consumer)</h2>

<p>Dans un <strong>deuxième terminal</strong> :</p>

<pre>
<code>
docker exec -it bdcc-kafka-broker kafka-console-consumer \
  --bootstrap-server broker:9092 \
  --topic R2 \
  --from-beginning
</code>
</pre>

<p>Vous verrez :</p>

<pre>
<code>
Hello Kafka
Message 1
Message 2
</code>
</pre>

<hr>

</body>
</html>
