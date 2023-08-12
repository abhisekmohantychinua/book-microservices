import uuid

from django.db import models


# Create your models here.

class Book(models.Model):
    book_id = models.CharField(primary_key=True, max_length=36, default=uuid.uuid4(), editable=False)
    book_name = models.CharField(max_length=50)
    book_author = models.CharField(max_length=100)
    book_price = models.IntegerField()
    book_count = models.IntegerField()
