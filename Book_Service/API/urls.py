from django.urls import path
from API.views import books
from API.views import book_detail

urlpatterns = [
    path('', books),
    path('<str:book_id>', book_detail)
]
