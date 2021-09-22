from functools import wraps
from flask import Flask, Response, render_template, request


import os
from time import sleep
import json
from flask import jsonify


import logging

app = Flask("interactif")
app.run(host='0.0.0.0',debug=True)

@app.route('/')
def home():
    return render_template('home.html')






################ GLOBAL STATE VARS DECLARATION ##############



################ API ROUTES ##############

@app.route('/api/effects/mask/pitterboxing', methods=['GET', 'POST', 'DELETE'])
def pitterboxing():
    if request.method == 'POST':
        with open('store.json') as config_file:
            data = json.load(config_file)
        sumLetterboxing = int(data['sumLetterboxing'])
        sumPillarboxing = int(data['sumPillarboxing'])
        letterboxing = request.form.get('letterboxing')
        pillarboxing = request.form.get('pillarboxing')

        sumLetterboxing = int(letterboxing) + int(sumLetterboxing)
        sumPillarboxing = int(pillarboxing) + int(sumPillarboxing)
        data = {
            "sumLetterboxing" : sumLetterboxing,
            "sumPillarboxing" : sumPillarboxing
        }
        with open('store.json', 'w') as outfile:
            json.dump(data, outfile)
        return jsonify(
            letterboxing = sumLetterboxing,
            pillarboxing = sumPillarboxing
        )
    if request.method == 'GET':
        # Loading config file
        with open('store.json') as config_file:
            data = json.load(config_file)
        sumLetterboxing = data['sumLetterboxing']
        sumPillarboxing = data['sumPillarboxing']
        return jsonify(
            var1 = sumLetterboxing,
            var2 = sumPillarboxing
        )
    if request.method == 'DELETE':
        data = {
            "sumLetterboxing" : 0,
            "sumPillarboxing" : 0
        }
        with open('store.json', 'w') as outfile:
            json.dump(data, outfile)
        return "pillarboxing has been reset"

@app.route('/api/novel/responses', methods=['GET', 'POST', 'DELETE'])
def novel():
    if request.method == 'GET':
        response = [
            {
                "id" : 1,
                "text" : "Option 1",
                "vote" : 10
            },
                        {
                "id" : 1,
                "text" : "Option 2",
                "vote" : 12
            }
        ]
        return jsonify(response)