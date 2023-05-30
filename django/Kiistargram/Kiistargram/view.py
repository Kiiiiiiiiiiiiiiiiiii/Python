from django.shortcuts import render
from rest_framework.views import APIView

class Sub(APIView):
    def get(self, request):
        print('Get call')
        return render(request, 'Kiistargram/main.html')

    def post(self, request):
        print('Post call')
        return render(request, 'Kiistargram/main.html')