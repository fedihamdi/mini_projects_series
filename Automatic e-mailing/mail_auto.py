import smtplib
import csv
from string import Template
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText

def read_template(filename):
   with open(filename, 'r', encoding='utf-8') as template_file:
      template_file_content = template_file.read()
   return Template(template_file_content)

MY_ADDRESS = "fedihamdi"  #your gmail account address
PASSWORD = "*******************************"         #your App password
s = smtplib.SMTP(host='smtp.gmail.com', port=587)
s.starttls()
s.login(MY_ADDRESS, PASSWORD)

# read the message template
message_template = read_template('template.txt')
with open('details.csv', 'r') as csv_file:
 csv_reader = csv.reader(csv_file, delimiter=',')
 # skip the first row as it is the header
 next(csv_reader)
 for row in csv_reader:
   msg = MIMEMultipart() # create a message
# add in the actual person name to the message template
   message=message_template.substitute(PERSON_NAME=row[0],MATH=row[2],ENG=row[3],SCI=row[4])
   
   # Prints out the message body for our sake
   print(message)
# setup the parameters of the message
   msg['From']=MY_ADDRESS
   msg['To']=row[1]
   msg['Subject']='Mid term grades'
# add in the message body
   msg.attach(MIMEText(message, 'plain'))
# send the message via the server set up earlier.
   s.send_message(msg)
   del msg
 
# Terminate the SMTP session and close the connection
s.quit()

# if __name__ == '__main__':
#    main()